package com.example.myfpolyapp.models;

public class InfoDetailApiModel {
    private boolean status;
    private NotificationModel data;

    public InfoDetailApiModel(boolean status, NotificationModel data) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public NotificationModel getData() {
        return data;
    }

    public void setData(NotificationModel data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InfoDetailApiModel{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
