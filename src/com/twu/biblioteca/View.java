package com.twu.biblioteca;

public class View {

    Route route;

    public View(Route r){
        route = r;
    }
    public void display(){

    }

    public View next(String in){
        return this;
    }
}
