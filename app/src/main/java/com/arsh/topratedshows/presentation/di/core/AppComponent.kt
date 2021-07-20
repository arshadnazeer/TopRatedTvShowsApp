package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.presentation.di.tvtoprated.TvTopRatedSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
CacheDataModule::class,
RemoteDataModule::class,
LocalDataModule::class,
NetModule::class,
DataBaseModule::class,
RepositoryModule::class,
UseCaseModule::class
])
interface AppComponent{
    fun tvTopRatedComponent(): TvTopRatedSubComponent.Factory
}