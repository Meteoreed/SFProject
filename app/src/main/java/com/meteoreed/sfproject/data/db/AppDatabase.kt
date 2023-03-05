package com.meteoreed.sfproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meteoreed.sfproject.data.DAO.FilmDao
import com.meteoreed.sfproject.data.Entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}