package com.twu.biblioteca;

public class ErrorView extends View {

    private String msg = "Please select a valid option!";

    public void display(){ System.out.println(msg); }

    public String goTo(String in) { return "optionsView"; }
}
