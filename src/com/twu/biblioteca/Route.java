package com.twu.biblioteca;

import java.util.Scanner;

public class Route {

    public WelcomeView welcomeView;
    public OptionsView optionsView;
    public BooksView booksView;

    public Scanner userInput = new Scanner(System.in);

    {
        welcomeView = new WelcomeView();
        optionsView = new OptionsView();
        booksView = new BooksView();
    }

    public void setUp(){
        booksView.booksController.loadCatalog();
    }


    public void run() {
        welcomeView.display();

        // Change view when 'Enter'
        userInput.nextLine();

        optionsView.display();
        optionSwitch(Integer.valueOf(userInput.nextLine()));
    }

    private void optionSwitch(int in) {
        switch(in){
            case 1:
                booksView.display();
                break;
        }
    }

}
