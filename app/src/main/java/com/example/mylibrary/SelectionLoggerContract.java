package com.example.mylibrary;

import android.provider.BaseColumns;

public final class SelectionLoggerContract {
    private SelectionLoggerContract(){};

    public static class LoggerEntry implements BaseColumns {
        public static final String TABLE_NAME = "selections";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_WRITER = "writer";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
    }
}