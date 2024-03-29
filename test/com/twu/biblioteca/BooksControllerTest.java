package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BooksControllerTest {

    private List<Book> catalog;
    private BooksController bc;

    @Before
    public void setUp() {
        bc = new BooksController();

        catalog = new ArrayList<Book>();
        catalog.add(new Book(1,"Title1", "Author1", "1993"));
        catalog.add(new Book(2,"Title2", "Author2", "1986"));
        catalog.add(new Book(3,"Title3", "Author3", "2009"));

        bc.catalog = catalog;
    }

    @Test
    public void testGetAvailableBooksList() {
        assertEquals(3, bc.getAvailableBooksList().size());
        assertEquals("Title1", bc.getAvailableBooksList().get(0).getTitle());
        assertEquals("Author2", bc.getAvailableBooksList().get(1).getAuthor());
        assertEquals("2009", bc.getAvailableBooksList().get(2).getYear());
    }

    @Test
    public void testCheckoutAndReturnBook(){
        // Test Checkout
        assertEquals(3, bc.getAvailableBooksList().size());
        assertTrue(bc.checkoutBook(2));
        assertEquals(2, bc.getAvailableBooksList().size());

        for (Book b: bc.getAvailableBooksList()){
            assertNotEquals(2, b.getId());
        }

        // Test checkout not available books
        assertFalse(bc.checkoutBook(11));
        assertFalse(bc.checkoutBook(2));

        assertEquals("Title1", bc.getAvailableBookById(1).getTitle());
        assertEquals("Author3", bc.getAvailableBookById(3).getAuthor());
        assertNull(bc.getAvailableBookById(2));

        // Test Return
        assertFalse(bc.returnBook(3));
        assertTrue(bc.returnBook(2));
        assertEquals(3, bc.getAvailableBooksList().size());
    }


}