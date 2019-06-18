package com.twu.biblioteca;

public class MoviesView extends View{

    public MoviesController moviesController = new MoviesController();

    public MoviesView(Route r){
        super(r);
    }


    public void display(){
        for (Movie movie : moviesController.getAvailableMovies()) {
            System.out.format("%10d%16s%16s%16s%16s\n", movie.getId(), movie.getName(), movie.getYear(), movie.getDirector(), movie.getRate());
        }
        System.out.println("Press 'c' and the movie id to check it out. E.g: c1");
        System.out.println("Press 'r' and the movie id to return it. E.g: r1");

    }

}
