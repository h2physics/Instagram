package com.h2physics.instagram.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class InstaDbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "instagram.db";
    private static final int DATABASE_VERSION = 1;

    public InstaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InstaPersistenceContrat.UserEntry.SQL_CREATE_STATEMENT);
        db.execSQL(InstaPersistenceContrat.PhotoEntry.SQL_CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + InstaPersistenceContrat.PhotoEntry.TABLE_PHOTO + ";");
        db.execSQL("DROP TABLE IF EXISTS " + InstaPersistenceContrat.UserEntry.TABLE_USER + ";");
        onCreate(db);
    }
}
