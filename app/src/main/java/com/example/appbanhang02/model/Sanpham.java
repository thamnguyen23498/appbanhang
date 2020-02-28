package com.example.appbanhang02.model;

public class Sanpham {
    public int masp;
    public String tensp;
    public String hinhanhsp;
    public String motasp;
    public int maloaisp;
    public Integer giasp;

    public Sanpham(String tensp, String hinhanhsp, Integer giasp) {
        this.tensp = tensp;
        this.hinhanhsp = hinhanhsp;
        this.giasp = giasp;
    }

    public Sanpham(int masp, String tensp, Integer giasp, String hinhanhsp, String motasp, int maloaisp) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanhsp = hinhanhsp;
        this.motasp = motasp;
        this.maloaisp = maloaisp;

    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public String getMotasp() {
        return motasp;
    }

    public void setMotasp(String motasp) {
        this.motasp = motasp;
    }

    public Integer getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(Integer maloaisp) {
        this.maloaisp = maloaisp;
    }

    public Integer getGiasp() {
        return giasp;
    }

    public void setGiasp(Integer giasp) {
        this.giasp = giasp;
    }
}
