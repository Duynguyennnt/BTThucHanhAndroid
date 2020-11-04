package com.example.baitaptuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvpeople;
    ArrayList<people> peopleArrayList;
    peopleAdapter peopleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        peopleAdapter = new peopleAdapter(this, R.layout.dong_people, peopleArrayList);
        lvpeople.setAdapter(peopleAdapter);
    }
    private void anhxa(){
        lvpeople = (ListView) findViewById(R.id.lvpeople);
        peopleArrayList = new ArrayList<>();
        peopleArrayList.add(new people("Jonh", "368 604 577",R.drawable.hinh1));
        peopleArrayList.add(new people("DonaTruma", "321 112 121",R.drawable.hinh2));
        peopleArrayList.add(new people("MocTaBi", "431 564 211",R.drawable.hinh3));
        peopleArrayList.add(new people("XugaRi", "321 112 221",R.drawable.hinh4));
        peopleArrayList.add(new people("RiBi AB", "213 131 213",R.drawable.hinh5));
        peopleArrayList.add(new people("Lisa", "213 222 881",R.drawable.hinh6));

    }
}