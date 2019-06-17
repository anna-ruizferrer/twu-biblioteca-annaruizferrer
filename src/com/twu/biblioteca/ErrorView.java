package com.twu.biblioteca;

public class ErrorView extends View {

    public ErrorView(Route r){ super(r); }

    private String msg = "Please select a valid option!";

    public void display(){ System.out.println(msg); }

    public View next(String in) { return route.optionsView; }
}
