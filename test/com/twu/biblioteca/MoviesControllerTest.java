package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesControllerTest {

    @Test
    public void shouldBeOneMovieWhenAMovieIsAvailable(){
        MoviesController mc = new MoviesController();

        mc.addMovie(new Movie(1, "Name 1", "2001", "Director 1", "9.0"));

        assertEquals(1, mc.getAvailableMovies().size());
        assertEquals("Name 1", mc.getAvailableMovies().get(0).getName());
    }

    @Test
    public void shouldBeThreeMoviesWhenThreeMoviesAreAvailable(){
        MoviesController mc = new MoviesController();

        mc.addMovie(new Movie(1, "Name 1", "2001", "Director 1", "9.0"));
        mc.addMovie(new Movie(2, "Name 2", "1991", "Director 2", "3.1"));
        mc.addMovie(new Movie(3, "Name 3", "2011", "Director 3", "9.4"));

        assertEquals(3, mc.getAvailableMovies().size());
        assertEquals("Name 1", mc.getAvailableMovies().get(0).getName());
        assertEquals("1991", mc.getAvailableMovies().get(1).getYear());
        assertEquals("Director 3", mc.getAvailableMovies().get(2).getDirector());
    }

}