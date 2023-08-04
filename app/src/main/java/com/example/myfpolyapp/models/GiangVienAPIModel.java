package com.example.myfpolyapp.models;

import java.util.List;

public class GiangVienAPIModel {
    private String status;
    private List<GiangVienModel> data;

    public GiangVienAPIModel(String status, List<GiangVienModel> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GiangVienModel> getData() {
        return data;
    }

    public void setData(List<GiangVienModel> data) {
        this.data = data;
    }
}
