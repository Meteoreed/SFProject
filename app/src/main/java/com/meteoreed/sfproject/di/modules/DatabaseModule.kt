package com.meteoreed.sfproject.di.modules

import android.content.Context
import androidx.room.Room
import com.meteoreed.sfproject.data.DAO.FilmDao
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "film_db").build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}