package com.example.baitaptuan4listviewcustoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listbacsic;
    ArrayList<String> arraybasic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listbacsic =(ListView) findViewById(R.id.listViewId);
        arraybasic = new ArrayList<>();
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        arraybasic.add("hello");
        ArrayAdapter ap = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arraybasic);
        listbacsic.setAdapter(ap);
    }
}