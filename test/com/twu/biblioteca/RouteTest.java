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
    }

    @Test
    public void testRun() {

        // Pre-define user input to interact with the App
        InputStream in = new ByteArrayInputStream("\n".getBytes()); // Input 'Enter' to go from WelcomeView to BooksView
        r.userInput = new Scanner(in);

        r.run();

        verify(r.welcomeView).display();
        verify(r.booksView).display();
    }
}
