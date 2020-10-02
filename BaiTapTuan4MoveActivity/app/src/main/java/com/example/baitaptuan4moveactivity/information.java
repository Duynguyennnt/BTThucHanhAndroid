package com.example.baitaptuan4moveactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class information extends AppCompatActivity {
    private Button btnql,btncontinues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informationuser);
        btnql = (Button) findViewById(R.id.btreply);
        btnql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(information.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btncontinues = (Button) findViewById(R.id.btct);
        btncontinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(information.this, wiget.class);
                startActivity(intent);
            }
        });
    }
}