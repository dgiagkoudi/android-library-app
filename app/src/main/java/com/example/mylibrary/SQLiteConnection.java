package com.example.mylibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mylibrary.Book;
import com.example.mylibrary.SelectionLoggerContract;
import com.example.mylibrary.SelectionLoggerDbHelper;

import java.util.Date;

public class SQLiteConnection {

    private SQLiteDatabase db;

    public SQLiteConnection(Context context) {
        SelectionLoggerDbHelper dbHelper = new SelectionLoggerDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Book book) {

        ContentValues values = new ContentValues();
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TITLE, book.getTitle());
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_WRITER, book.getWriter());
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_DESCRIPTION, book.getDescription());
        values.put(SelectionLoggerContract.LoggerEntry.COLUMN_NAME_TIMESTAMP,
                new Date(System.currentTimeMillis()).toString());

        return db.insert(
                SelectionLoggerContract.LoggerEntry.TABLE_NAME,
                null,
                values
        );
    }

    public void close() {
        db.close();
    }
}
