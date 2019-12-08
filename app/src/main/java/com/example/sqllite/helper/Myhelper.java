package com.example.sqllite.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sqllite.MainActivity;
import com.example.sqllite.model.words;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

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
        super( context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = " CREATE TABLE " + tbl_name + "("
                + wordId + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + wordName + " TEXT ,"
                + meaning + " TEXT "+ ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String wordName1, String meaning1, SQLiteDatabase db){
        try{
            String query = " INSERT INTO " + tbl_name + "("+ wordName + "," + meaning + ")"
                    + " VALUES ('" + wordName1 + "','" + meaning1 + "')";
            db.execSQL(query);

            return true;

        }catch (Exception e){
            Log.d("Error :", e.toString());
            return false;
        }
    }

    public List<words> GetAllWords(SQLiteDatabase db){
        List<words> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery(" select * from " + tbl_name, null);

        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                dictionaryList.add(new words(cursor.getInt(0),cursor.getString(1)
                        ,cursor.getString(2)));
            }
        }
        return dictionaryList;
    }
}
