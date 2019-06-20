package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class RouteTest {

    public Route r;

    @Before
    public void setUp(){
        r = new Route();
        r.setPrinter(mock(Printer.class));
    }

    @Test
    public void shouldDisplayWelcomeMessageAtStart(){
        String orders = "q\n";
        InputStream in = new ByteArrayInputStream(orders.getBytes());
        r.userInput = new Scanner(in);

        r.run();

        verify(r.getPrinter()).print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void shouldDisplayMoviesViewWhenOptionChosen() {
        r.optionsView = mock(OptionsView.class);
        r.optionsView.route = r;
        r.moviesView = mock(MoviesView.class);

        when(r.optionsView.execute(any(String.class))).thenCallRealMethod();

        String orders = "2\nq\n";
        InputStream in = new ByteArrayInputStream(orders.getBytes());
        r.userInput = new Scanner(in);

        r.run();

        verify(r.moviesView).display();
    }

    @Test
    public void shouldSendUserInputToMoviesViewWhenSeeingListOfMovies() {
        r.optionsView = mock(OptionsView.class);
        r.optionsView.route = r;
        r.moviesView = mock(MoviesView.class);

        when(r.optionsView.execute(any(String.class))).thenCallRealMethod();
        when(r.moviesView.execute(any(String.class))).thenReturn(r.moviesView);

        String orders = "2\nc1\nq\n";
        InputStream in = new ByteArrayInputStream(orders.getBytes());
        r.userInput = new Scanner(in);

        r.run();

        verify(r.moviesView).execute("c1");
    }
}