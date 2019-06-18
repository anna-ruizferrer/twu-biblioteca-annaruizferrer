package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BooksController {

    public List<Book> catalog = new ArrayList<Book>();

    public List<Book> getAvailableBooksList(){
        List<Book> availableBooks = new ArrayList<Book>();

        for (Book b: catalog) {
            if (b.isAvailable()) {
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }

    public Book getAvailableBookById(int id){

        for (Book b: catalog) {
            if (b.getId() == id && b.isAvailable()) {
                return b;
            }
        }
        return null;
    }

    public Boolean checkoutBook(int i){
        Book b = getAvailableBookById(i);
        if (b != null) {
            b.checkout();
            return true;
        }
        return false;
    }

    public void loadCatalog(){
        try {
            File file = new File("doc/books_database.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int id = 1;
            while ((line = bufferedReader.readLine()) != null) {
                String[] b = line.split("\t");
                catalog.add(new Book(id++, b[0], b[1], b[2]));
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
