package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.data.db.TvTopRatedDao
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedLocalDataSource
import com.arsh.topratedshows.data.repository.datasourceimpl.TvTopRatedLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesTvTopRatedLocalDataSource(tvTopRatedDao: TvTopRatedDao) : TvTopRatedLocalDataSource{
        return TvTopRatedLocalDataSourceImpl(tvTopRatedDao)
    }
}