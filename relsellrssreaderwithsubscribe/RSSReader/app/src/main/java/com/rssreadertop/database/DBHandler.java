/*
 * Copyright (c) 2017. Relsell Global
 */


package com.rssreadertop.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.os.IResultReceiver;

import com.rssreadertop.pojo.IRSSItem;
import com.rssreadertop.pojo.RSSItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anilkukreti on 13/05/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "rss.db";
    public static final int DATABASE_VERSION = 1;


    public static class FeedTable {
        private static final String KEY_ID = "id";
        private static final String KEY_LINK = "link";
        private static final String KEY_TITLE = "title";
        private static final String KEY_PUBDATE = "pubdate";
        public static final String FEED_TABLE = "users";

    }


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FEED_TABLE = "CREATE TABLE " + FeedTable.FEED_TABLE + "("
                + FeedTable.KEY_ID + " INTEGER PRIMARY KEY,"
                + FeedTable.KEY_TITLE + " TEXT UNIQUE,"
                + FeedTable.KEY_PUBDATE + " TEXT" + ")";


        db.execSQL(CREATE_FEED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FeedTable.FEED_TABLE);


        onCreate(db);
    }


    public void addFeedsData(IRSSItem irssItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedTable.KEY_LINK, irssItem.getLink());
        values.put(FeedTable.KEY_TITLE, irssItem.getTitle());
        values.put(FeedTable.KEY_PUBDATE, irssItem.getPubDate());


        Cursor cursor = db.query(FeedTable.FEED_TABLE, new String[]{FeedTable.KEY_ID,
                        FeedTable.KEY_LINK, FeedTable.KEY_TITLE, FeedTable.KEY_PUBDATE}, FeedTable.KEY_LINK + "=?",
                new String[]{irssItem.getLink()}, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            // do nothing since row is already there.
        } else {
            db.insert(FeedTable.FEED_TABLE, null, values);
        }

        db.close();

    }

    public List<IRSSItem> getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<IRSSItem> irssItemList = new ArrayList<>();
        Cursor cursor = db.query(FeedTable.FEED_TABLE, new String[]{FeedTable.KEY_ID,
                FeedTable.KEY_LINK, FeedTable.KEY_TITLE, FeedTable.KEY_PUBDATE},null,null,null,null,FeedTable.KEY_ID+" DESC","10");

        if(cursor != null && cursor.getCount() > 0) {

            while(cursor.moveToNext()) {

                IRSSItem irssItem = new RSSItem();
                irssItem.setLink(cursor.getString(cursor.getColumnIndexOrThrow(FeedTable.KEY_LINK)));
                irssItem.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(FeedTable.KEY_TITLE)));
                irssItem.setPubDate(cursor.getString(cursor.getColumnIndexOrThrow(FeedTable.KEY_PUBDATE)));
                irssItemList.add(irssItem);

            }



        }

        return irssItemList;

    }


}
