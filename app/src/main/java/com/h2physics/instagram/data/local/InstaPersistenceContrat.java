package com.h2physics.instagram.data.local;

import android.provider.BaseColumns;

import com.h2physics.instagram.data.model.Photo;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public final class InstaPersistenceContrat {
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String TEXT_TYPE = " TEXT";

    private InstaPersistenceContrat(){

    }

    public static final class PhotoEntry implements BaseColumns{
        public static final String TABLE_PHOTO = "photos";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LIKES = "likes";
        public static final String COLUMN_URLS = "urls";
        public static final String COLUMN_USER_ID = "user_id";

        public static final String SQL_CREATE_STATEMENT = "CREATE TABLE " + TABLE_PHOTO + "(" +
                COLUMN_ID + TEXT_TYPE + " PRIMARY KEY, " +
                COLUMN_LIKES + INTEGER_TYPE + " NOT NULL, " +
                COLUMN_URLS + TEXT_TYPE + " NOT NULL, " +
                COLUMN_USER_ID + TEXT_TYPE + " FOREIGNKEY REFERENCES " +
                UserEntry.TABLE_USER + "(" + UserEntry.COLUMN_ID + ")" + ");";
    }

    public static final class UserEntry implements BaseColumns{
        public static final String TABLE_USER = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USER_URL = "user_url";
        public static final String COLUMN_BIOLOGY = "biology";
        public static final String COLUMN_LOCATION = "location";
        public static final String COLUMN_TOTAL_LIKES = "total_likes";
        public static final String COLUMN_TOTAL_PHOTOS = "total_photos";
        public static final String COLUMN_PROFILE_IMAGE = "profile_image";

        public static final String SQL_CREATE_STATEMENT = "CREATE TABLE " + TABLE_USER + "(" +
                COLUMN_ID + TEXT_TYPE + " PRIMARY KEY, " +
                COLUMN_USERNAME + TEXT_TYPE + " NOT NULL, " +
                COLUMN_NAME + TEXT_TYPE + " NOT NULL, " +
                COLUMN_USER_URL + TEXT_TYPE + " NOT NULL, " +
                COLUMN_BIOLOGY + TEXT_TYPE + " NOT NULL, " +
                COLUMN_LOCATION + TEXT_TYPE + " NOT NULL, " +
                COLUMN_TOTAL_LIKES + INTEGER_TYPE + " NOT NULL, " +
                COLUMN_TOTAL_PHOTOS + INTEGER_TYPE + " NOT NULL, " +
                COLUMN_PROFILE_IMAGE + TEXT_TYPE + " NOT NULL" + ");";
    }
}
