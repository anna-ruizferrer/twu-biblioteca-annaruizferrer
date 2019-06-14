package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RouteTest {

    public Route r = new Route();

    @Before
    public void setUp() {
        //Set up view mock classes to verify display methods are called
        r.welcomeView = mock(WelcomeView.class);
        r.booksView = mock(BooksView.class);
        r.optionsView = mock(OptionsView.class);
    }

    @Test
    public void testRun() {

        // Pre-define user input to interact with the App
        String orders;
        orders = "\n";      // 'Enter' to go from WelcomeView to OptionsView
        orders += "1\n";    // '1' to go from OptionsView to BooksView

        InputStream in = new ByteArrayInputStream(orders.getBytes());
        r.userInput = new Scanner(in);

        r.run();

        verify(r.welcomeView).display();
        verify(r.optionsView).display();
        verify(r.booksView).display();
    }
}
