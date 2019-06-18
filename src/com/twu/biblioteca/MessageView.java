package com.twu.biblioteca;

public class MessageView extends View{

    private String msg = "";

    public MessageView(Route r, String m){ super(r); msg = m;}

    public void display(){ System.out.println(msg + "\n\n"); }

}
