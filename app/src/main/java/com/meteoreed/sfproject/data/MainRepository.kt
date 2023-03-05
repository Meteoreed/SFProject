package com.meteoreed.sfproject.data

import android.content.ContentValues
import android.database.Cursor
import androidx.lifecycle.LiveData
import com.meteoreed.sfproject.data.DAO.FilmDao
import com.meteoreed.sfproject.data.Entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> = filmDao.getCachedFilms()
}
