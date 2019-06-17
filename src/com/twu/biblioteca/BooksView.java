package com.twu.biblioteca;

public class BooksView extends View {

    public BooksController booksController;

    public BooksView(){
        booksController = new BooksController();
    }

    public void display(){
        for (Book book : booksController.getAvailableBooksList()) {
            System.out.format("%10d%16s%16s%16s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
        }
        System.out.println("Press 'c' and the book id to check it out. E.g: c1");
    }

    public String goTo(String in) {
        switch (in.charAt(0)){
            case 'c':
                System.out.println(Integer.valueOf(in.substring(1)));
                booksController.checkoutBook(Integer.valueOf(in.substring(1)));
                return "booksView";
            default:
                return "booksView";

        }
    }
}
