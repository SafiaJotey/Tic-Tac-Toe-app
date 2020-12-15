package com.example.myintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelpe extends SQLiteOpenHelper {
    public  static  final String dBName="university.db";
    public  static  final String tableName="students";
    public static final String Col_1="ID";
    public static final String Col_2="NAME";


    public DatabaseHelpe(@Nullable Context context) {
        super(context, dBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ tableName + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name varchar(50),Section TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);

    }

    public long insertData(String NameData){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues mycontentValues= new ContentValues();
        mycontentValues.put("Name",NameData);
        return  db.insert(tableName,null,mycontentValues);



    }


    public Cursor ViewData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultData;
        resultData=db.rawQuery("SELECT * FROM "+tableName,null);
        return resultData;
    }

}
