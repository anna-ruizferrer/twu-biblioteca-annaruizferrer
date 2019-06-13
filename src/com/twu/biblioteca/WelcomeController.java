package com.twu.biblioteca;

public class WelcomeController {

    private String msg;

    {
        msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getMsg(){ return msg; }
}
