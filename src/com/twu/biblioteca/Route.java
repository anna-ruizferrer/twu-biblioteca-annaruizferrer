package com.twu.biblioteca;

import java.util.Scanner;

public class Route {

    public WelcomeView welcomeView;
    public BooksView booksView;

    public Scanner userInput = new Scanner(System.in);

    {
        welcomeView = new WelcomeView();
        booksView = new BooksView();
    }

    public void setUp(){
        booksView.booksController.loadCatalog();
    }


    public void run() {
        welcomeView.display();

        // Change view when 'Enter'
        userInput.nextLine();
        booksView.display();
    }


}
