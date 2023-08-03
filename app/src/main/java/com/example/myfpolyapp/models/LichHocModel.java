package com.example.myfpolyapp.models;

public class LichHocModel {
    private int id;
    private String giangDuong;
    private String phong;
    private String maMon;
    private String tenMon;
    private String caHoc;
    private String ngay;
    private String tenGiangVien;
    private int type; // New field for status

    public LichHocModel(int id, String giangDuong, String phong, String maMon, String tenMon, String caHoc, String ngay, String tenGiangVien, int type) {
        this.id = id;
        this.giangDuong = giangDuong;
        this.phong = phong;
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.caHoc = caHoc;
        this.ngay = ngay;
        this.tenGiangVien = tenGiangVien;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiangDuong() {
        return giangDuong;
    }

    public void setGiangDuong(String giangDuong) {
        this.giangDuong = giangDuong;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
