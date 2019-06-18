package com.twu.biblioteca;

public class Book {

    private int id;
    private String title;
    private String author;
    private String year;
    private Boolean available;

    public Book(int i, String t, String a, String y){
        id = i;
        title = t;
        author = a;
        year = y;
        available = true;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getYear(){
        return year;
    }

    public Boolean isAvailable() { return available; }

    public void checkout() { if (available) { available = false; } }

    public void returnit() { if (!available) { available = true; }

    }
}
