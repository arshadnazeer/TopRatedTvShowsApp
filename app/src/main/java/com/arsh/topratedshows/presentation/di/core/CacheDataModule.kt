package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.data.repository.datasource.TvTopRatedCacheDataSource
import com.arsh.topratedshows.data.repository.datasourceimpl.TvTopRatedCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesTvTopRatedCacheDataSource(): TvTopRatedCacheDataSource{
        return TvTopRatedCacheDataSourceImpl()
    }
}