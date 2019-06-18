package com.twu.biblioteca;

public class Movie {

    private int id;
    private String name;
    private String year;
    private String director;
    private String rate;
    private Boolean available;

    public Movie(int i, String n, String y, String d, String r){
        id = i;
        name = n;
        year = y;
        director = d;
        rate = r;
        available = true;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getYear(){
        return year;
    }

    public String getDirector(){
        return director;
    }

    public String getRate(){
        return rate;
    }

    public boolean isAvailable() {
        return available;
    }
}
