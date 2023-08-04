package com.example.myfpolyapp.models;

public class GiangVienModel {
    private int id;
    private int id_user;
    private String name;
    private String title;
    private String content;
    private String created_at;
    private String image;
    private int status;

    public GiangVienModel(int id, int id_user, String name, String title, String content, String created_at, String image, int status) {
        this.id = id;
        this.id_user = id_user;
        this.name = name;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.image = image;
        this.status = status;
    }

    // Getters and Setters (optional, but good practice)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GiangVienModel{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }
}
