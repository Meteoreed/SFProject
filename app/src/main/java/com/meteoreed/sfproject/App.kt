package com.meteoreed.sfproject

import android.app.Application
import com.meteoreed.sfproject.di.AppComponent
import com.meteoreed.sfproject.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
        private set
    }
}

