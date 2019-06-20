package com.twu.biblioteca;

public class BooksView extends View {


    public BooksController booksController;

    public BooksView(Route r){
        super(r);
        booksController = new BooksController();
    }

    public void display(){
        String str = "";
        for (Book book : booksController.getAvailableBooksList()) {
            str += String.format("%10d%16s%16s%16s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
        }
        str += "Press 'c' and the book id to check it out. E.g: c1\n";
        str += "Press 'r' and the book id to return it. E.g: r1\n";
        route.getPrinter().print(str);
    }

    public View execute(String in) {
        if (in.matches("c\\d+")) {
            if (booksController.checkoutBook(Integer.valueOf(in.substring(1)))) {
                route.getPrinter().print("Thank you! Enjoy the book");
            } else {
                route.getPrinter().print("Sorry, that book is not available");
            }
        }
        if (in.matches("r\\d+")) {
            if (booksController.returnBook(Integer.valueOf(in.substring(1)))) {
                route.getPrinter().print("Thank you for returning the book");
            } else {
                route.getPrinter().print("That is not a valid book to return");
            }
        }
        return this;
    }
}
