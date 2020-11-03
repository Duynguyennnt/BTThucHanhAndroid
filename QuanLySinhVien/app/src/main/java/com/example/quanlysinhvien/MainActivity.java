package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tc:
                break;
            case R.id.dkm:
                break;
            case R.id.dkl:
                break;
            case R.id.ttsv:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}