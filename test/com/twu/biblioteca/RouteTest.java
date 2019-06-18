package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class RouteTest {

    @Test
    public void shouldDisplayMoviesViewWhenOptionChosen() {
        Route r = new Route();
        r.optionsView = mock(OptionsView.class);
        r.optionsView.route = r;
        r.moviesView = mock(MoviesView.class);

        when(r.optionsView.next(any(String.class))).thenCallRealMethod();

        String orders = "2\nq\n";
        InputStream in = new ByteArrayInputStream(orders.getBytes());
        r.userInput = new Scanner(in);

        r.run();

        verify(r.moviesView).display();
    }
}