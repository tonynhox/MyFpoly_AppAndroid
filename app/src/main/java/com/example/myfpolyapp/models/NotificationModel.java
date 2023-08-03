package com.example.myfpolyapp.models;

import java.util.Date;

public class NotificationModel {
    private int id;
    private String title;
    private String created_at;
    private String namecreated;
    private String content;

    public NotificationModel(int id, String title, String created_at, String namecreated, String content) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
        this.namecreated = namecreated;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getNamecreated() {
        return namecreated;
    }

    public void setNamecreated(String namecreated) {
        this.namecreated = namecreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    @Override
//    public String toString() {
//        return "NotificationModel{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", created_at=" + created_at +
//                ", namecreated='" + namecreated + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
