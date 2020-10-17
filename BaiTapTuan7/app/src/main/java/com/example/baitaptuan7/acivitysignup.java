package com.example.baitaptuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class acivitysignup extends AppCompatActivity {
    private Button btnsignup, btnlogin;
    private EditText ed_username, ed_password, ed_passwordagain;
    private String ten, mk;
    private ImageButton btnprevlistmusic, btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivitysignup);
        anhxa();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(acivitysignup.this,MainActivity.class);
                intent.putExtra("user",ten);
                intent.putExtra("pass",mk);
                startActivity(intent);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_username.getText().length() !=0 && ed_password.getText().length() !=0 && ed_passwordagain.getText().length() !=0){
                    if (ed_password.getText().toString().equals(ed_passwordagain.getText().toString())){
                        ten = ed_username.getText().toString().trim();
                        mk = ed_password.getText().toString().trim();
                        Toast.makeText(acivitysignup.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(acivitysignup.this,"Mật khẩu không trùng",Toast.LENGTH_SHORT).show();
                    }
                }else {
                        Toast.makeText(acivitysignup.this,"Không để trống các trường",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnprevlistmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(acivitysignup.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),acivitysignup.class);
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
        btnlogin = (Button) findViewById(R.id.btnloginsignup);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        ed_username = (EditText) findViewById(R.id.editTextTextEmailAddresssignup);
        ed_password = (EditText) findViewById(R.id.editTextTextPassword);
        ed_passwordagain = (EditText) findViewById(R.id.editTextTextPasswordagain);
        btnprevlistmusic = (ImageButton) findViewById(R.id.btnbtnprevsignup);
        btnhome = (ImageButton) findViewById(R.id.outsignup);
    }
}