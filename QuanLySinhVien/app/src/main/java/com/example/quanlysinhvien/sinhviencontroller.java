package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class sinhviencontroller {
    Database database;
    SQLiteDatabase sqLiteDatabase;
//    String array[] = new String[]{database.COLUMN_ID,database.COLUMN_NAME,database.COLUMN_EMAIL,database.COLUMN_GT,database.COLUMN_LOP,database.COLUMN_SDT};

    public sinhviencontroller(Context context){
        database = new Database(context);
    }
    //open data
    public void open(){
        sqLiteDatabase = database.getWritableDatabase();

    }
    //close data
    public void  close(){
        database.close();
    }
    //insert data
    public long addsv(sinhvien sv){
        ContentValues cv = new ContentValues();
        cv.put(database.COLUMN_NAME,sv.getTen());
        cv.put(database.COLUMN_GT,sv.getGioitinh());
        cv.put(database.COLUMN_SDT,sv.getSodt());
        cv.put(database.COLUMN_LOP,sv.getLophoc());
        cv.put(database.COLUMN_EMAIL,sv.getEmail());

        return sqLiteDatabase.insert(database.TABLE_NAME,null,cv);
    }
    //update sv
    public long updatesv(sinhvien sv){
        ContentValues cv = new ContentValues();
        cv.put(database.COLUMN_NAME,sv.getTen());
        cv.put(database.COLUMN_GT,sv.getGioitinh());
        cv.put(database.COLUMN_SDT,sv.getSodt());
        cv.put(database.COLUMN_LOP,sv.getLophoc());
        cv.put(database.COLUMN_EMAIL,sv.getEmail());

        return sqLiteDatabase.update(database.TABLE_NAME,cv,database.COLUMN_ID+"="+ sv.getId(),null);
    }
    //delete sv

    public long deletesv(int id){
        return sqLiteDatabase.delete(database.TABLE_NAME,database.COLUMN_ID+"="+ id, null);
    }
    // select data sv
    public ArrayList<sinhvien> getsv(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ database.TABLE_NAME +";", null);
        ArrayList<sinhvien> arrayList = new ArrayList<>();
        while (cursor.moveToNext()){
            sinhvien sv1 = new sinhvien();
            sv1.setId(cursor.getInt(cursor.getColumnIndex(database.COLUMN_ID)));
            sv1.setTen(cursor.getString(cursor.getColumnIndex(database.COLUMN_NAME)));
            sv1.setEmail(cursor.getString(cursor.getColumnIndex(database.COLUMN_EMAIL)));
            sv1.setGioitinh(cursor.getString(cursor.getColumnIndex(database.COLUMN_GT)));
            sv1.setLophoc(cursor.getString(cursor.getColumnIndex(database.COLUMN_LOP)));
            sv1.setSodt(cursor.getString(cursor.getColumnIndex(database.COLUMN_SDT)));
            arrayList.add(sv1);
        }
        return  arrayList;
    }
}
