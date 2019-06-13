package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class RouteTest {

    @Test
    public void testStart() {
        Route r = new Route();
        r.welcomeView = mock(WelcomeView.class);

        r.start();

        verify(r.welcomeView).display();
    }
}
