package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String year;

    public Book(String t, String a, String y){
        title = t;
        author = a;
        year = y;
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
}
