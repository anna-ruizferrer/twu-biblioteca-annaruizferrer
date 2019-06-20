package com.twu.biblioteca;

public class MoviesView extends View{

    public MoviesController moviesController = new MoviesController();

    public MoviesView(Route r){
        super(r);
    }


    public void display(){
        String str = "";
        for (Movie movie : moviesController.getAvailableMovies()) {
            str += String.format("%10d%16s%16s%16s%16s\n", movie.getId(), movie.getName(), movie.getYear(), movie.getDirector(), movie.getRate());
        }
        str += "Press 'c' and the movie id to check it out. E.g: c1\n";
        str += "Press 'r' and the movie id to return it. E.g: r1\n";
        route.getPrinter().print(str);
    }

    public View execute(String in) {
        if (in.matches("c\\d+")) {
            if (moviesController.checkoutMovie(Integer.valueOf(in.substring(1)))) {
                route.getPrinter().print("Thank you! Enjoy the movie");
            } else {
                route.getPrinter().print("Sorry, that movie is not available");
            }
        }
        if (in.matches("r\\d+")) {
            if (moviesController.returnMovie(Integer.valueOf(in.substring(1)))) {
                route.getPrinter().print("Thank you for returning the movie");
            } else {
                route.getPrinter().print("That is not a valid movie to return");
            }
        }
        return this;
    }
}
