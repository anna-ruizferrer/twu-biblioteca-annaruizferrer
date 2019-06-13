package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBook() {
        String title = "Title";
        Book b = new Book(title);
        assertEquals(title, b.getTitle());
    }

}