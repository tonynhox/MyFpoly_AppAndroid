package com.example.myfpolyapp.models;


public class UserAPIModel {
    private String status;
    private UserModel user;
    private String token;

    public UserAPIModel() {
    }

    public UserAPIModel(String status, UserModel userModel, String token) {
        this.status = status;
        this.user = userModel;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModel getUserModel() {
        return user;
    }

    public void setUserModel(UserModel user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
