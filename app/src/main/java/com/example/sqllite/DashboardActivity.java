package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button btnAdd, btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAdd = findViewById(R.id.btnAddWords);
        btnDisplay = findViewById(R.id.btnDisplayWords);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DisplayWordActivity.class);
                startActivity(intent);
            }
        });

    }
}
