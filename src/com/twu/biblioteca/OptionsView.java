package com.twu.biblioteca;

public class OptionsView {
    public OptionsController optionsController;
    {
        optionsController = new OptionsController();
    }

    public void display(){
        for (Option opt : optionsController.getOptionsList()) {
            System.out.format("%6d%20s\n", opt.getId(), opt.getName());
        }
    }
}
