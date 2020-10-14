package com.example.baitaptuan7;

public class music {
    private String ten;
    private String casi;
    private int anh;

    public music(String ten, String casi, int anh) {
        this.ten = ten;
        this.casi = casi;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
