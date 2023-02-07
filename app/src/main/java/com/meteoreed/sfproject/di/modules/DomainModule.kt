package com.meteoreed.sfproject.di.modules

import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService =  tmdbApi)
}