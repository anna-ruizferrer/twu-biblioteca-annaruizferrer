package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WelcomeControllerTest {

    @Test
    public void testGetMsg() {
        WelcomeController wc = new WelcomeController();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", wc.getMsg());
    }

}
