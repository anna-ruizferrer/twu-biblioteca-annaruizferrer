package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBook() {
        String title = "Title";
        String author = "Author";
        String year = "2017";

        Book b = new Book(title, author, year);
        assertEquals(title, b.getTitle());
        assertEquals(author, b.getAuthor());
        assertEquals(year, b.getYear());
    }

}