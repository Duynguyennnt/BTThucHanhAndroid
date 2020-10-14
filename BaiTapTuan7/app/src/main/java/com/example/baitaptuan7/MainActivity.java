package com.example.baitaptuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnlogin, btnsignup;
    private EditText ed_userM, ed_passM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        getdata();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listViewMusic.class);
                startActivity(intent);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, acivitysignup.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa(){
        btnsignup = (Button) findViewById(R.id.btndk);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        ed_userM = (EditText) findViewById(R.id.editTextTextEmailAddress);
        ed_passM = (EditText) findViewById(R.id.editTextTextPassword);
    }
    private void getdata(){
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pass = intent.getStringExtra("pass");
        ed_userM.setText(user);
        ed_passM.setText(pass);
    }
}