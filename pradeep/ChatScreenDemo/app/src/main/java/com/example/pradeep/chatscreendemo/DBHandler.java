package com.example.pradeep.chatscreendemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pradeep.chatscreendemo.dbattributes.UserPojo;

/**
 * Created by anilkukreti on 13/05/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user.db";
    public static final int DATABASE_VERSION = 1;
    public static final String USER_TABLE = "userdata";

    private static final String KEY_ID = "id";
    private static final String KEY_USER_NAME = "username";
    private static final String KEY_EMAIL_ID = "email";
    private static final String KEY_PASSWORD = "password";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + USER_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER_NAME + " TEXT,"
                + KEY_EMAIL_ID + " TEXT UNIQUE ," + KEY_PASSWORD + " TEXT " + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addUserData(UserPojo obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_ID,obj.getID());
        values.put(KEY_USER_NAME,obj.getUsername());
        values.put(KEY_EMAIL_ID,obj.getEmailid());
        values.put(KEY_PASSWORD,obj.getPassword());

        // Inserting Row
        db.insert(USER_TABLE, null, values);
        db.close(); // Closing database connection

    }

    public void removeUserData(UserPojo obj) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(USER_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getID()) });
        db.close();

    }

    public int updateUserData(UserPojo obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,obj.getID());
        values.put(KEY_USER_NAME,obj.getUsername());
        values.put(KEY_EMAIL_ID,obj.getEmailid());
        values.put(KEY_PASSWORD,obj.getPassword());

        // updating row
        return db.update(USER_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getID()) });

    }

    public UserPojo fetchUserData(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(USER_TABLE, new String[] { KEY_ID,
                        KEY_USER_NAME, KEY_EMAIL_ID,KEY_PASSWORD }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        UserPojo student = new UserPojo();
        student.setID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
        student.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(KEY_USER_NAME)));
        student.setEmailid(cursor.getString(cursor.getColumnIndexOrThrow(KEY_EMAIL_ID)));
        student.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(KEY_PASSWORD)));

        return student;
    }


}
