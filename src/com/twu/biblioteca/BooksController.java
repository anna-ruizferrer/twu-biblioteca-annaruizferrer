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

    public List<String> getTitlesList(){
        List<String> titles = new ArrayList<String>();
        for(Book book: catalog) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    private void loadCatalog(){
        try {
            File file = new File("doc/books_database.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                catalog.add(new Book(line));
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
