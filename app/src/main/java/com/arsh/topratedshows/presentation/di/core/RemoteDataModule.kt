package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.data.api.TMDBService
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedRemoteDataSource
import com.arsh.topratedshows.data.repository.datasourceimpl.TvTopRatedRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun providesTvTopRatedRemoteDataSource(tmdbService: TMDBService): TvTopRatedRemoteDataSource{
        return TvTopRatedRemoteDataSourceImpl(tmdbService,apiKey)
    }
}