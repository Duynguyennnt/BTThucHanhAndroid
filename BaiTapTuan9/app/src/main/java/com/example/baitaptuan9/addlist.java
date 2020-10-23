//package com.example.baitaptuan9;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class addlist extends AppCompatActivity {
//    EditText editTextTen, editTextmsv, editTextlop, editTextLink;
//    Button btnadd;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_addlist);
//        anhxa();
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(addlist.this, sinhvienview.class);
//                intent.putExtra("ten",editTextTen.getText().toString());
//                intent.putExtra("masv",editTextmsv.getText().toString());
//                intent.putExtra("lop",editTextlop.getText().toString());
//                intent.putExtra("hinh",editTextLink.getText().toString());
//                startActivity(intent);
//            }
//        });
//    }
//    private void anhxa(){
//        btnadd = (Button) findViewById(R.id.btnadd);
//        editTextTen = (EditText) findViewById(R.id.editten);
//        editTextmsv = (EditText) findViewById(R.id.editmsv);
//        editTextlop = (EditText) findViewById(R.id.editlop);
//    }
//}