package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MoviesViewTest {

    Route r;
    MoviesView mv;

    @Before
    public void setUp(){
        r = new Route();
        mv = new MoviesView(r);
        r.setPrinter(mock(Printer.class));
    }

    @Test
    public void shouldCheckoutMovieWhenInputCId(){
        mv.moviesController = mock(MoviesController.class);

        mv.execute("c1");
        verify(mv.moviesController).checkoutMovie(1);
    }

    @Test
    public void shouldDisplaySuccessMessageWhenSuccessfulCheckout(){
        mv.moviesController = mock(MoviesController.class);
        when(mv.moviesController.checkoutMovie(1)).thenReturn(true);

        mv.execute("c1");
        verify(r.getPrinter()).print("Thank you! Enjoy the movie");
    }

    @Test
    public void shouldDisplayUnsuccessMessageWhenUnsuccessfulCheckout(){
        mv.moviesController = mock(MoviesController.class);
        when(mv.moviesController.checkoutMovie(1)).thenReturn(false);

        mv.execute("c1");
        verify(r.getPrinter()).print("Sorry, that movie is not available");
    }

    @Test
    public void shouldDisplaySuccessMessageWhenSuccessfulReturn(){
        mv.moviesController = mock(MoviesController.class);
        when(mv.moviesController.returnMovie(1)).thenReturn(true);

        mv.execute("r1");
        verify(r.getPrinter()).print("Thank you for returning the movie");
    }

    @Test
    public void shouldDisplayUnsuccessMessageWhenUnsuccessfulReturn(){
        mv.moviesController = mock(MoviesController.class);
        when(mv.moviesController.returnMovie(1)).thenReturn(false);

        mv.execute("r1");
        verify(r.getPrinter()).print("That is not a valid movie to return");
    }

}