package com.arsh.topratedshows.presentation

import android.app.Application
import com.arsh.topratedshows.BuildConfig
import com.arsh.topratedshows.presentation.di.Injector
import com.arsh.topratedshows.presentation.di.core.*
import com.arsh.topratedshows.presentation.di.tvtoprated.TvTopRatedSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createTvTopRatedComponent(): TvTopRatedSubComponent {
        return appComponent.tvTopRatedComponent().create()
    }


}