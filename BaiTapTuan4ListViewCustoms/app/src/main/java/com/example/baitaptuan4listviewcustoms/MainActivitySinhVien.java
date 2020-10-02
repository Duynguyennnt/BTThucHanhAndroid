package com.example.baitaptuan4listviewcustoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivitySinhVien extends AppCompatActivity {
    ListView lvsinhvien;
    ArrayList<sinhVien> arraySinhVien;
    sinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewsinhvien);
        anhXa();
        adapter = new sinhVienAdapter(this,R.layout.row_sinhvien, arraySinhVien);
        lvsinhvien.setAdapter(adapter);
    }
    private void anhXa(){
        lvsinhvien = (ListView) findViewById(R.id.listviewsv);
        arraySinhVien = new ArrayList<>();
        arraySinhVien.add(new sinhVien("Nguyễn Thanh Duy","1811505310411","18T4",R.drawable.chandung1));
        arraySinhVien.add(new sinhVien("Nguyễn Hoàng Lãnh","1811505310410","18T4",R.drawable.chandung2));
        arraySinhVien.add(new sinhVien("Tôn Nữ Trà Ngư","1811505310421","18T4",R.drawable.chandung3));
        arraySinhVien.add(new sinhVien("Võ Nguyễn Hoàng Minh","1811505310414","18T4",R.drawable.chandung4));
        arraySinhVien.add(new sinhVien("Võ Nữ Oanh","1811505310415","18T4",R.drawable.chandung5));
        arraySinhVien.add(new sinhVien("Cò Thị Bé","1811505310416","18T4",R.drawable.chandung6));
        arraySinhVien.add(new sinhVien("Trương Minh Đạt","1811505310417","18T4",R.drawable.chandung7));
        arraySinhVien.add(new sinhVien("Bùi Công Đức","1811505310418","18T4",R.drawable.chandung8));
        arraySinhVien.add(new sinhVien("Trần Thị Như Ý","1811505310419","18T4",R.drawable.chandung9));

    }
}