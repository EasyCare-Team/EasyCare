package com.example.easycare_home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "register.db";
    public static  final String TABLE_NAME = "registeruser";
    public static  final String COL_1 = "ID";
    public static  final String COL_2 = "email";
    public static  final String COL_3 = "username";
    public static  final String COL_4 = "password";
    //public static  final String col4 = "register.db";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, email VARCHAR, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public long addUser(String email, String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", user);
        contentValues.put("password", password);

        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }
    public boolean checkUser(String username, String password){
        String [] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?" + " and " + COL_4 + "=?";
        String [] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null,null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if (count > 0)
            return true;
        else
            return false;
    }

//    public DatabaseHelper (Context context){
//        super(context, "Login db", null, 1);
//    }
//
//    public void onCreate (SQLiteDatabase db){
//        db.execSQL("Create table user (username text primary key, username text, password text)");
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists user");
//
//    }
//    public Boolean insert (String username, String email, String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("username", username);
//        contentValues.put("email", email);
//        contentValues.put("password", password);
//        long ins = db.insert("user", null, contentValues);
//        if (ins == 1) return false;
//        else return true;
//
//    }
//    public Boolean chkemail (String email){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("Select * from user where email =?", new String[]{email});
//        if (cursor.getCount() > 0) return false;
//        else return true;
//    }
//    public Boolean usernamepassword (String username, String password){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("Select * from user where username =? and password =?", new String[]{username, password});
//        if (cursor.getCount() > 0) return false;
//        else return true;
//    }
}
