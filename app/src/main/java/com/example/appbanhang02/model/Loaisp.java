package com.example.appbanhang02.model;

public class Loaisp {
    public int maloaisp;
    public String tenloaisp;
    public String hinhanhloaisp;

    public Loaisp(int maloaisp, String tenloaisp, String hinhanhloaisp) {
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
        this.hinhanhloaisp = hinhanhloaisp;
    }

    public Loaisp(String tenloaisp, String hinhanhloaisp) {
        this.tenloaisp = tenloaisp;
        this.hinhanhloaisp = hinhanhloaisp;
    }

    public int getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public String getHinhanhloaisp() {
        return hinhanhloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        this.hinhanhloaisp = hinhanhloaisp;
    }
}
