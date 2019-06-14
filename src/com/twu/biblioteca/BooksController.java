package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BooksController {

    public List<Book> catalog = new ArrayList<Book>();

    public BooksController(){
        loadCatalog();
    }

    public List<Book> getBooksList(){
        List<Book> books = new ArrayList<Book>();
        for(Book b: catalog) {
            books.add(b);
        }
        return books;
    }

    private void loadCatalog(){
        try {
            File file = new File("doc/books_database.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] b = line.split("\t");
                catalog.add(new Book(b[0], b[1], b[2]));
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
