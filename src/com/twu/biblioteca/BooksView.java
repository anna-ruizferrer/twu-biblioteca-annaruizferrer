package com.twu.biblioteca;

public class BooksView extends View {

    public BooksController booksController;

    public BooksView(Route r){
        super(r);
        booksController = new BooksController();
    }

    public void display(){
        for (Book book : booksController.getAvailableBooksList()) {
            System.out.format("%10d%16s%16s%16s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
        }
        System.out.println("Press 'c' and the book id to check it out. E.g: c1");
    }

    public View next(String in) {
        if (in.matches("c\\d+")) {
            if (booksController.checkoutBook(Integer.valueOf(in.substring(1)))) {
                new MessageView(route, "Thank you! Enjoy the book").display();
            } else {
                new MessageView(route, "Sorry, that book is not available").display();
            }
        }
        return this;
    }
}
