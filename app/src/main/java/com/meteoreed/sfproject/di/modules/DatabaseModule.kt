package com.meteoreed.sfproject.di.modules

import com.meteoreed.sfproject.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideReposityory() = MainRepository()
}