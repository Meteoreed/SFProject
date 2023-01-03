package com.meteoreed.sfproject

import android.app.Application
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.domain.Interactor

class App: Application() {
    lateinit var repo: MainRepository
    lateinit var interactor: Interactor

    override fun onCreate() {
        super.onCreate()
        instance = this
        repo = MainRepository()
        interactor = Interactor(repo)
    }

    companion object {
        lateinit var instance: App
        private set
    }
}