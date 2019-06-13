package com.twu.biblioteca;

public class Route {

    public WelcomeView welcomeView;

    {
        welcomeView = new WelcomeView();
    }

    public void start(){
        welcomeView.display();
    }
}
