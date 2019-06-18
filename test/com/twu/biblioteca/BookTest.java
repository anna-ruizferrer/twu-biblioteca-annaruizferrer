package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBook() {
        String title = "Title";
        String author = "Author";
        String year = "2017";

        Book b = new Book(0, title, author, year);
        assertEquals(title, b.getTitle());
        assertEquals(author, b.getAuthor());
        assertEquals(year, b.getYear());
        assertEquals(0, b.getId());

        assertTrue(b.isAvailable());
        b.checkout();
        assertFalse(b.isAvailable());

        b.returnit();
        assertTrue(b.isAvailable());

    }

}