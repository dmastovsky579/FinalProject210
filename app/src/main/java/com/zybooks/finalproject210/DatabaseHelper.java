package com.zybooks.finalproject210;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Feedback";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_IMPROVEMENT = "improvement";
    public static final String COLUMN_MEAL_REQUEST = "meal_request";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_RATING + " INTEGER, " +
                COLUMN_IMPROVEMENT + " TEXT, " +
                COLUMN_MEAL_REQUEST + " TEXT)";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle future upgrades
    }

    public void addFormData(String name, String email, int rating, String improvement, String mealRequest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_RATING, rating);
        values.put(COLUMN_IMPROVEMENT, improvement);
        values.put(COLUMN_MEAL_REQUEST, mealRequest);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getLastRecord() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, new String[] {
                COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL, COLUMN_RATING, COLUMN_IMPROVEMENT, COLUMN_MEAL_REQUEST
        }, null, null, null, null, COLUMN_ID + " DESC", "1");
    }
}
