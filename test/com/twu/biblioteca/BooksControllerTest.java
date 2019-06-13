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
        catalog.add(new Book("Title1"));
        catalog.add(new Book("Title2"));
        catalog.add(new Book("Title3"));

        bc.catalog = catalog;
    }

    @Test
    public void testGetTitlesList() {
        assertEquals(3, bc.getTitlesList().size());
        assertEquals("Title1", bc.getTitlesList().get(0));
    }

}