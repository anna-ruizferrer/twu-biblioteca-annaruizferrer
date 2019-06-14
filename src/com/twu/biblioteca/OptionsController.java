package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class OptionsController {
    public List<Option> options = new ArrayList<Option>();

    public OptionsController(){
        options.add(new Option(1, "Go to Books List"));
    }

    public List<Option> getOptionsList(){
        return options;
    }
}
