package com.twu.biblioteca;

public class WelcomeView extends View {

    private WelcomeController welcomeC;

    public WelcomeView(){
        welcomeC = new WelcomeController();
    }

    public void display(){
        System.out.println(welcomeC.getMsg());
    }

    public String goTo(String in) { return "optionsView"; }
}
