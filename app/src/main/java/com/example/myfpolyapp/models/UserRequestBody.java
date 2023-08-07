package com.example.myfpolyapp.models;

public class UserRequestBody {
    private String email;
    private String name;
    private String avatar;

    public UserRequestBody(String email, String name, String avatar) {
        this.email = email;
        this.name = name;
        this.avatar = avatar;
    }
}
