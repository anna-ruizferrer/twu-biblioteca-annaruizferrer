package com.twu.biblioteca;

public class BooksView {

    private BooksController booksC;

    public BooksView(){
        booksC = new BooksController();
    }

    public void display(){
        for (Book book : booksC.getBooksList()) {
            System.out.format("%16s%16s%16s\n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }
}
