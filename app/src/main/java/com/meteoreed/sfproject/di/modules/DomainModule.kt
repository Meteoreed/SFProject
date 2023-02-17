package com.meteoreed.sfproject.di.modules

import android.content.Context
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.PreferenceProvider
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(val context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Provides
    @Singleton
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) =
        Interactor(repo = repository, retrofitService =  tmdbApi, preferences = preferenceProvider)
}