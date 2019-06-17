package com.twu.biblioteca;

public class CheckoutView extends View {
    private String msg = "Please enter the book id of the desired book to checkout.";

    public void display(){ System.out.println(msg); }

    public String goTo(String in) { return "booksView"; }
}
