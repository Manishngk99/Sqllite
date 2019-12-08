package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqllite.helper.Myhelper;
import com.example.sqllite.model.words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayWordActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);

        listView = findViewById(R.id.firstWord);
        LoadWord();
    }

    private void LoadWord(){

        final Myhelper myhelper = new Myhelper(DisplayWordActivity.this);
        final SQLiteDatabase sqLiteDatabase = myhelper.getWritableDatabase();

        List<words> wordsList = new ArrayList<>();
        wordsList = myhelper.GetAllWords(sqLiteDatabase);

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i  = 0; i <wordsList.size(); i++){
            hashMap.put( wordsList.get(i).getWord(), wordsList.get(i).getMeaning());
        }

        ArrayAdapter<String> StringArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())

        );

        listView.setAdapter(StringArrayAdapter);


    }
}
