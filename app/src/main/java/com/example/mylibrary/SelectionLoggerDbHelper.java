package com.example.mylibrary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mylibrary.SelectionLoggerContract;

public class SelectionLoggerDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SelectionLogger.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SelectionLoggerContract.LoggerEntry.TABLE_NAME + " (" +
                    SelectionLoggerContract.LoggerEntry._ID + " INTEGER PRIMARY KEY," +
                    SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TITLE + " TEXT," +
                    SelectionLoggerContract.LoggerEntry.COLUMN_NAME_WRITER + " TEXT," +
                    SelectionLoggerContract.LoggerEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                    SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TIMESTAMP + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS "+SelectionLoggerContract.LoggerEntry.TABLE_NAME;


    public SelectionLoggerDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
