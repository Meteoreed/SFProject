package com.meteoreed.sfproject

import android.app.Application
import com.meteoreed.sfproject.di.AppComponent
import com.meteoreed.sfproject.di.DaggerAppComponent
import com.meteoreed.sfproject.di.modules.DatabaseModule
import com.meteoreed.sfproject.di.modules.DomainModule
import com.meteoreed.sfproject.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
        private set
    }
}

