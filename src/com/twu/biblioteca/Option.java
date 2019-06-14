package com.twu.biblioteca;

public class Option {

    private int id;
    private String name;

    public Option(int i, String n){
        id = i;
        name = n;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
