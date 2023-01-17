package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2;

public class Message {

    public Message(String user, String text) {
        this.username = user;
        this.text = text;
    }

    private String username;

    private String text;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
