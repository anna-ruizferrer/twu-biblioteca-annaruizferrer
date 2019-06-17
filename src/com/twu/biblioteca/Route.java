package com.twu.biblioteca;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Route {

    public WelcomeView welcomeView = new WelcomeView();
    public OptionsView optionsView = new OptionsView();
    public BooksView booksView = new BooksView();
    public ErrorView errorView = new ErrorView();

    HashMap<String, View> viewsMap = new HashMap<String, View>();

    public Scanner userInput = new Scanner(System.in);

    public Route() {
        viewsMap.put("welcomeView", welcomeView);
        viewsMap.put("optionsView", optionsView);
        viewsMap.put("booksView", booksView);
        viewsMap.put("errorView", errorView);
    }

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

                currentView = viewsMap.get(currentView.goTo(in));
            }
            catch (NoSuchElementException e){ break; }
        }
    }

}
