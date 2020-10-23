package com.example.baitaptuan9;

public class sinhvien {
    private String ten;
    private  String msv;
    private String lop;
    private int chandung;

    public sinhvien(String ten, String msv, String lop, int chandung) {
        this.ten = ten;
        this.msv = msv;
        this.lop = lop;
        this.chandung = chandung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getChandung() {
        return chandung;
    }

    public void setChandung(int chandung) {
        this.chandung = chandung;
    }
}
