package com.example.myfpolyapp.models;

public class NotificationModel {
    private int id;
    private String title;
    private String author;
    private String date;
    private String contents;

    public NotificationModel(int id, String title, String author, String date, String contents) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getContents() {
        return contents;
    }
}
