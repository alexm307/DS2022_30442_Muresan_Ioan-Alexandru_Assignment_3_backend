package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2;

public class ChatMessage {

    public ChatMessage(String from, String to, String text) {
        this.userFrom = from;
        this.userTo = to;
        this.text = text;
    }

    private String userFrom;

    private String userTo;

    private String text;

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
