package com.twu.biblioteca;

public class OptionsView extends View {
    public OptionsController optionsController;

    public OptionsView(Route r){
        super(r);
        optionsController = new OptionsController();
    }

    public void display(){
        for (Option opt : optionsController.getOptionsList()) {
            System.out.format("%6d%20s\n", opt.getId(), opt.getName());
        }
    }

    public View next(String in){
        int i;
        try
        {
            i = Integer.valueOf(in);
        }
        catch (NumberFormatException e)
        {
            i = -1;
        }

        switch(i){
            case 1:
                return route.booksView;
            default:
                return route.errorView;
        }
    }
}
