package com.example.quanlysinhvien;

import java.util.ArrayList;

public class sinhvienlist {
    public static sinhvienlist sv;
    ArrayList<sinhvien> arrayListsv;
    static {
        sv = new sinhvienlist();
    }
    public static sinhvienlist getsv(){
        return sv;
    }

}
