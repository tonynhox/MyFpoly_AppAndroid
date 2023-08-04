package com.example.myfpolyapp.models;

import java.util.List;

public class NotifiAPIModel {
    private String status;
    private List<NotificationModel> data;

    public NotifiAPIModel(String status, List<NotificationModel> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NotificationModel> getData() {
        return data;
    }

    public void setData(List<NotificationModel> data) {
        this.data = data;
    }
}
