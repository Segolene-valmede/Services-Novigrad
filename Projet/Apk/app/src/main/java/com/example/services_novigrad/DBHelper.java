package com.example.services_novigrad;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "Signup.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username Text primary key, password Text, email Text, rights Text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }
    public void resetTable(SQLiteDatabase myDB) {
        // Clear existing data or reset the table
        myDB.execSQL("DELETE FROM users");
    }

    @SuppressLint("Range")
    public String getRole(String username){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String[] columns = {"rights"};
        String selection = "username = ?";
        String[] selectionArgs = {username};

        Cursor cursor = myDB.query("users", columns, selection, selectionArgs, null, null, null);
        String role = "";

        if (cursor.moveToFirst()) {
            role = cursor.getString(cursor.getColumnIndex("rights"));
        }

        cursor.close();
        return role;
    }

    public Boolean insertData(String username, String password,String email, String rights){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("rights", rights);
        long result = myDB.insert("users", null, contentValues);

        if(result ==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
        }
    public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password =?", new String[] {username, password});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }
    }



