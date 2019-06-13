package com.twu.biblioteca;

public class WelcomeView {

    private WelcomeController welcomeC;

    public WelcomeView(){
        welcomeC = new WelcomeController();
    }

    public void display(){
        System.out.println(welcomeC.getMsg());
    }
}
