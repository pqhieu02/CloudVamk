package com.example.assignment41;

public class Comment {
    private String date;
    private String userName;
    private String comment;

    public Comment(String date, String userName, String comment) {
        this.date = date;
        this.userName = userName;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", date, userName, comment);
    }
}
