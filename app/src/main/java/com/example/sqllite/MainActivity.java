package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqllite.helper.Myhelper;

public class MainActivity extends AppCompatActivity {


    EditText etWord,etMeaning;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnSearch= findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Myhelper myhelper = new Myhelper( MainActivity.this);

                SQLiteDatabase sqLiteDatabase = myhelper.getWritableDatabase();

                boolean toCheckError = myhelper.InsertData(etWord.getText().toString(),etMeaning.getText().toString(), sqLiteDatabase);

                if (toCheckError == true){
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
