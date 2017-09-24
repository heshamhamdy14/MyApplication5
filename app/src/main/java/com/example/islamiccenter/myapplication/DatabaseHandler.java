package com.example.islamiccenter.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by islamic center on 22/09/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "sign up data";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String id ="id";
    private static final String user_name = "user name";
    private static final String email = "email";
    private static final String password = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + id + " INTEGER PRIMARY KEY," + user_name + " TEXT,"
                + email + " TEXT," + password +"String" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);

    }

    void inset_data(String user_name,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(user_name, user_name);
        values.put(email, email);
        values.put(password, password);

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);

    }
    public ArrayList getAlldata() {
        ArrayList dataList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String t1=cursor.getString(0);
                String t2=cursor.getString(1);
                String t3=cursor.getString(2);
                String t4=cursor.getString(3);
                dataList.add(t1+"-"+t2+" : "+t3+" -- "+t4);
            cursor.moveToNext();
        }

        // return contact list
        return dataList;
    }
}
