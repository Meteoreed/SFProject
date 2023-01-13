package com.meteoreed.sfproject

import android.app.Application
import com.meteoreed.sfproject.data.ApiConstants
import com.meteoreed.sfproject.data.MainRepository
import com.meteoreed.sfproject.data.TmdbApi
import com.meteoreed.sfproject.domain.Interactor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App : Application() {
    lateinit var repo: MainRepository
    lateinit var interactor: Interactor
    lateinit var retrofitService: TmdbApi

    override fun onCreate() {
        super.onCreate()
        instance = this
        repo = MainRepository()
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofitService = retrofit.create(TmdbApi::class.java)
        interactor = Interactor(repo, retrofitService)
    }

    companion object {
        lateinit var instance: App
            private set
    }


}

