package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Route {

    public WelcomeView welcomeView = new WelcomeView(this);
    public OptionsView optionsView = new OptionsView(this);
    public BooksView booksView = new BooksView(this);
    public ErrorView errorView = new ErrorView(this);

    public Scanner userInput = new Scanner(System.in);

    public void setUp(){
        booksView.booksController.loadCatalog();
    }

    public void run() {
        View currentView = welcomeView;

        while (true){
            currentView.display();
            try{
                String in = userInput.nextLine();
                if (in.equals("q")){
                    System.out.println("Goodbye! :)");
                    break;
                }
                currentView = currentView.next(in);
            }
            catch (NoSuchElementException e){ break; }
        }
    }

}
