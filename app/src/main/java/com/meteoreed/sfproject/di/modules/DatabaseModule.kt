package com.meteoreed.sfproject.di.modules

import android.content.Context
import com.meteoreed.sfproject.data.DatabaseHelper
import com.meteoreed.sfproject.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)
    @Provides
    @Singleton
    fun provideReposityory(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}