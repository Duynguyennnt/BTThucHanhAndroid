package com.example.baitaptuan4moveactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btListview;
    private EditText user;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btListview = (Button) findViewById(R.id.loginbt);
        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextNumberPassword);
        btListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equalsIgnoreCase("ThanhDuy") && pass.getText().toString().equalsIgnoreCase("123")){
                    Intent intent = new Intent(MainActivity.this, information.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"tài khoản hoặc mật khẩu không đúng",Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}