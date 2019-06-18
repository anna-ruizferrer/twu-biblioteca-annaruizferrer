package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Route {

    public OptionsView optionsView = new OptionsView(this);
    public BooksView booksView = new BooksView(this);

    public Scanner userInput = new Scanner(System.in);

    public void setUp(){
        booksView.booksController.loadCatalog();
    }

    public void run() {

        new MessageView(this, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!").display();
        View currentView = optionsView;

        while (true){
            currentView.display();
            try{
                String in = userInput.nextLine();
                if (in.equals("q")){
                    new MessageView(this, "Goodbye! :)").display();
                    break;
                }
                currentView = currentView.next(in);
            }
            catch (NoSuchElementException e){ break; }
        }
    }

}
