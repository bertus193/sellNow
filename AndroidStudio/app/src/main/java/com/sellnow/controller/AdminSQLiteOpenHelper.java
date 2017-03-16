package com.sellnow.controller;

/**
 * Created by sansanomiralles on 15/03/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,nombre,factory,version);
    }
    private String sqlCreate = "create table User(ID INTEGER PRIMARY KEY AUTOINCREMENT,email text, name text, password text)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {
        db.execSQL("drop table if exists User");
        db.execSQL(sqlCreate);
    }
}
