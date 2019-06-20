package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Route {

    private Printer printer = new Printer();

    public OptionsView optionsView = new OptionsView(this);
    public BooksView booksView = new BooksView(this);
    public MoviesView moviesView = new MoviesView(this);
    //public MessageView messageView = new MessageView(this);

    public Scanner userInput = new Scanner(System.in);

    public void setUp(){
        booksView.booksController.loadCatalog();
        moviesView.moviesController.loadCatalog();
    }


    public void run() {

        printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        View currentView = optionsView;

        while (true){
            currentView.display();
            try{
                String in = userInput.nextLine();

                if (in.equals("q")){
                    printer.print("Goodbye! :)");
                    break;
                }
                currentView = currentView.execute(in);
            }
            catch (NoSuchElementException e){ break; }
        }
    }

    public void setPrinter(Printer p){
        printer = p;
    }

    public Printer getPrinter(){
        return printer;
    }

}
