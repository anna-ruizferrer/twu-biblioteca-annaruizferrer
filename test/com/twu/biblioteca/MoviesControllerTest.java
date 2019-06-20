package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MoviesControllerTest {


    MoviesController mc;

    @Before
    public void setUp(){
        mc = new MoviesController();

        mc.addMovie(new Movie(1, "Name 1", "2001", "Director 1", "9.0"));
        mc.addMovie(new Movie(2, "Name 2", "1991", "Director 2", "3.1"));
        mc.addMovie(new Movie(3, "Name 3", "2011", "Director 3", "9.4"));
    }

    @Test
    public void shouldReturnAvailableMovies(){
        assertEquals(3, mc.getAvailableMovies().size());
        assertEquals("Name 1", mc.getAvailableMovies().get(0).getName());
        assertEquals("1991", mc.getAvailableMovies().get(1).getYear());
        assertEquals("Director 3", mc.getAvailableMovies().get(2).getDirector());
    }

    @Test
    public void shouldReturnTrueOnCheckoutMovieWithIdWhenItISAvailable(){
        Movie m = mock(Movie.class);

        when(m.getId()).thenReturn(5);
        when(m.isAvailable()).thenReturn(true);

        mc.addMovie(m);
        assertTrue(mc.checkoutMovie(5));
        verify(mc.getAvailableMovieById(5)).checkout();
        assertFalse(mc.checkoutMovie(6));
    }

    @Test
    public void shouldReturnTrueOnReturnMovieWithIdWhenItIsNotAvailable(){
        // Not available movie
        Movie m = mock(Movie.class);
        when(m.getId()).thenReturn(5);
        when(m.isAvailable()).thenReturn(false);

        mc.addMovie(m);
        assertTrue(mc.returnMovie(5));
        verify(mc.getNotAvailableMovieById(5)).returnit();

        // Available movie
        when(m.getId()).thenReturn(6);
        when(m.isAvailable()).thenReturn(true);
        mc.addMovie(m);

        assertFalse(mc.returnMovie(6));
    }

}