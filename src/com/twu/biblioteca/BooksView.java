package com.twu.biblioteca;

public class BooksView {

    private BooksController booksC;

    public BooksView(){
        booksC = new BooksController();
    }

    public void display(){
        for (String title : booksC.getTitlesList()) {
            System.out.println(title);
        }
    }
}
