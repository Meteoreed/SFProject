package com.meteoreed.sfproject.di

import com.meteoreed.sfproject.di.modules.DatabaseModule
import com.meteoreed.sfproject.di.modules.DomainModule
import com.meteoreed.sfproject.di.modules.RemoteModule
import com.meteoreed.sfproject.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        DomainModule::class,
        RemoteModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}