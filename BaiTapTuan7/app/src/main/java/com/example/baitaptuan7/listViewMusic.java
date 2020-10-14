package com.example.baitaptuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class listViewMusic extends AppCompatActivity {
    ListView lvmusic;
    ArrayList<music> arrayList;
    musicAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_music);
        anhxa();
        adapter = new musicAdapter(this,R.layout.listmusic,arrayList);
        lvmusic.setAdapter(adapter);
        lvmusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(listViewMusic.this, homemusic.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa(){
        lvmusic =(ListView) findViewById(R.id.lvmusicview);
        arrayList = new ArrayList<>();
        arrayList.add(new music("Hoa Hải Đường", "Jack",R.drawable.hoahaiduong));
        arrayList.add(new music("Là 1 Thằng Con Trai", "Jack",R.drawable.la1thangcontrai));
        arrayList.add(new music("Em Gì Ơi", "Jack",R.drawable.emgioi));
        arrayList.add(new music("Bạc Phận", "Jack",R.drawable.bacphan));
        arrayList.add(new music("Đường Quyền Tình Yêu", "Jack",R.drawable.duongquyentinhyeu));

    }
}