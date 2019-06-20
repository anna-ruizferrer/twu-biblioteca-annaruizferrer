package com.twu.biblioteca;

public class OptionsView extends View {
    public OptionsController optionsController;

    public OptionsView(Route r){
        super(r);
        optionsController = new OptionsController();
    }

    public void display(){
        String str = "";
        for (Option opt : optionsController.getOptionsList()) {
            str += String.format("%6d%20s\n", opt.getId(), opt.getName());
        }
        route.getPrinter().print(str);
    }

    public View execute(String in){
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
            case 2:
                return route.moviesView;
            default:
                route.getPrinter().print("Please select a valid option!");
                return this;
        }
    }
}
