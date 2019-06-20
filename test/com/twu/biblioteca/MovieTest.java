package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class MovieTest {

    @Test
    public void testMovie() {
        int id = 0;
        String name = "movie1";
        String year = "1993";
        String director = "director1";
        String rating = "9.1";

        Movie m = new Movie(id, name, year, director, rating);

        assertEquals(name, m.getName());
        assertEquals(year, m.getYear());
        assertEquals(director, m.getDirector());
        assertEquals(rating, m.getRate());
        assertEquals(id, m.getId());

        assertTrue(m.isAvailable());
    }

    @Test
    public void shouldNotBeAvailableAfterCheckoutAndAvailableAfterReturn(){
        Movie m = new Movie(0, "movie1", "1992", "director 1", "1.0");
        assertTrue(m.isAvailable());
        m.checkout();
        assertFalse(m.isAvailable());
        m.returnit();
        assertTrue(m.isAvailable());
    }

}