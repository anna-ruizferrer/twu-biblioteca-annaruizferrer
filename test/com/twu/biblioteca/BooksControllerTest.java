package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BooksControllerTest {

    private List<Book> catalog;
    private BooksController bc;

    @Before
    public void setUp() {
        bc = new BooksController();

        catalog = new ArrayList<Book>();
        catalog.add(new Book("Title1", "Author1", "1993"));
        catalog.add(new Book("Title2", "Author2", "1986"));
        catalog.add(new Book("Title3", "Author3", "2009"));

        bc.catalog = catalog;
    }

    @Test
    public void testGetStringBooksList() {
        assertEquals(3, bc.getBooksList().size());
        assertEquals("Title1", bc.getBooksList().get(0).getTitle());
        assertEquals("Author2", bc.getBooksList().get(1).getAuthor());
        assertEquals("2009", bc.getBooksList().get(2).getYear());
    }

}