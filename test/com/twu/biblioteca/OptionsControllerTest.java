package com.twu.biblioteca;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class OptionsControllerTest {

    @Test
    public void testGetOptionsList(){

        OptionsController oc = new OptionsController();

        List<Option> list = oc.getOptionsList();
        assertEquals(1, list.size());
        assertEquals("Go to Books List", list.get(0).getName());
        assertEquals(1, list.get(0).getId());
    }

}