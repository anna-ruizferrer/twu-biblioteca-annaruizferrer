package com.twu.biblioteca;

public class BooksView {

    public BooksController booksController;

    public BooksView(){
        booksController = new BooksController();
    }

    public void display(){
        for (Book book : booksController.getBooksList()) {
            System.out.format("%16s%16s%16s\n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }
}
