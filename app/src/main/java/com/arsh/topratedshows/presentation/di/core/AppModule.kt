package com.arsh.topratedshows.presentation.di.core

import android.content.Context
import com.arsh.topratedshows.presentation.di.tvtoprated.TvTopRatedSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [TvTopRatedSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context{
        return context.applicationContext
    }
}