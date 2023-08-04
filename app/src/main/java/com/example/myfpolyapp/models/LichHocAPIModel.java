package com.example.myfpolyapp.models;

import java.util.List;

public class LichHocAPIModel {
    private String status;
    private List<LichHocModel> data;

    public LichHocAPIModel() {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LichHocModel> getData() {
        return data;
    }

    public void setData(List<LichHocModel> data) {
        this.data = data;
    }
}
