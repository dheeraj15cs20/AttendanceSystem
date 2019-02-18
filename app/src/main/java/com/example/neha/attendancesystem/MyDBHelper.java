package com.example.neha.attendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "Timepass.db";

    public MyDBHelper(Context context){

        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "create table CLASSES (NAME TEXT PRIMARY KEY);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CLASSES ;");
        onCreate(sqLiteDatabase);

    }

    public boolean ADD_CLASS(String name){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);

        long result = sqLiteDatabase.insert("CLASSES",null,contentValues);

        if (result == -1)return false;

        sqLiteDatabase.execSQL("create table "+name+" (RegNo INTEGER PRIMARY KEY , NAME TEXT);");

        return true;

    }

    public Cursor GET_CLASS_NAME(){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM CLASSES",null);
        return cursor;

    }

    public Integer DELETE_CLASS(String id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+id);

        return sqLiteDatabase.delete("CLASSES","NAME = ?",new String[]{id});

    }
}
