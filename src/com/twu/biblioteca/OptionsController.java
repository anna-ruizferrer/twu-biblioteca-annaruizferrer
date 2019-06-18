package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class OptionsController {
    private List<Option> options = new ArrayList<Option>();

    public OptionsController(){
        options.add(new Option(1, "Go to Books List"));
        options.add(new Option(2, "Go to Movies List"));
    }

    public List<Option> getOptionsList(){
        return options;
    }

}
