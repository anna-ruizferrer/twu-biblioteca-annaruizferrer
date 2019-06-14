package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionTest {

    @Test
    public void testOption() {
        Option opt = new Option(1, "Option 1");

        assertEquals(1, opt.getId());
        assertEquals("Option 1", opt.getName());
    }

}