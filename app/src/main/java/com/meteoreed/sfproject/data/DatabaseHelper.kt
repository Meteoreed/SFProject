package com.meteoreed.sfproject.data

import android.app.DownloadManager.*
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_TITLE TEXT UNIQUE," +
                    "$COLUMN_POSTER TEXT," +
                    "$COLUMN_DESCRIPTION TEXT," +
                    "$COLUMN_RATING REAL);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        private const val DATABASE_NAME = "films.db"
        private const val DATABASE_VERSION = 1
        internal const val TABLE_NAME = "films_table"
        private const val COLUMN_ID = "id"
        internal const val COLUMN_TITLE = "title"
        internal const val COLUMN_POSTER = "poster_path"
        internal const val COLUMN_DESCRIPTION = "overview"
        internal const val COLUMN_RATING = "vote_average"
    }
}