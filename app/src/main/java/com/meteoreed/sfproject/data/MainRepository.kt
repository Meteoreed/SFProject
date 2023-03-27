package com.meteoreed.sfproject.data

import androidx.lifecycle.LiveData
import com.meteoreed.sfproject.data.DAO.FilmDao
import com.meteoreed.sfproject.data.Entity.Film
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()
}
