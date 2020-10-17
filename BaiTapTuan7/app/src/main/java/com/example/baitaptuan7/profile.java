package com.example.baitaptuan7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    TextView txtlogout,txtmusicofme;
    ImageButton imageButtonprev,imageButtonnext, imageButtonhome;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        anhxa();
        txtlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
        txtmusicofme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this,listViewMusic.class);
                startActivity(intent);
            }
        });
        imageButtonprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, listViewMusic.class);
                startActivity(intent);
            }
        });
        imageButtonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, listViewMusic.class);
                startActivity(intent);
            }
        });
        imageButtonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),profile.class);
                startActivity(intent);
                //vo lại
                Intent start = new Intent(Intent.ACTION_MAIN);
                start.addCategory(Intent.CATEGORY_HOME);
                startActivity(start);
                finish();
            }
        });
    }
    private void anhxa(){
        imageButtonhome = (ImageButton) findViewById(R.id.outprofile);
        imageButtonnext = (ImageButton) findViewById(R.id.nextlistmusic);
        imageButtonprev = (ImageButton) findViewById(R.id.prevprofile);
        txtlogout = (TextView) findViewById(R.id.logout);
        txtmusicofme = (TextView) findViewById(R.id.musicofme);
    }
}