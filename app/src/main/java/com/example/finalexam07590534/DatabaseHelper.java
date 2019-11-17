package com.example.finalexam07590534;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "reg.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(fullname text primary key,userid text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists user");
    }
    public boolean insert(String fullname,String userid,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("userid",userid);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }
public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
    if(cursor.getCount()>0) return false;
    else return true;
}
    public  boolean checklogin (String id , String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where id =?and pass=?" ,new String[]{id,pass});
        if (cursor.getCount() > 0){
            return  false ;
        }
        else  return  true;
    }



}
