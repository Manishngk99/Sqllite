package com.example.sqllite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Myhelper extends SQLiteOpenHelper {

//Database name and version
    private static final String db_name = "Dictionary";
    private static final int db_version = 1;

    //Table name
    private static final String tbl_name = "tblWord";

    //Columns
    private static final String wordId= "wordId";
    private static final String wordName = "wordName";
    private static final String meaning = "meaning";


    //Constructor
    public Myhelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
