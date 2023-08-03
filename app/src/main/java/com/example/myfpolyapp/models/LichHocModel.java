package com.example.myfpolyapp.models;

public class LichHocModel {
    private int id;
    private String room;
    private String day;
    private String time;
    private String course_name;
    private String teacher_name;
    private int type;
    private String class_name;
    private String address;

    public LichHocModel(int id, String room, String day, String time, String course_name,
                        String teacher_name, int type, String class_name, String address) {
        this.id = id;
        this.room = room;
        this.day = day;
        this.time = time;
        this.course_name = course_name;
        this.teacher_name = teacher_name;
        this.type = type;
        this.class_name = class_name;
        this.address = address;
    }


    @Override
    public String toString() {
        return "LichHocModel{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", course_name='" + course_name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", type=" + type +
                ", class_name='" + class_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
