package com.example.baitaptuan4moveactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wiget extends AppCompatActivity {
    private Button btnout, btnreply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgets);
        btnout = (Button) findViewById(R.id.idsignoff);
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wiget.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnreply = (Button) findViewById(R.id.idreply);
        btnreply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wiget.this, information.class);
                startActivity(intent);
            }
        });
    }
}