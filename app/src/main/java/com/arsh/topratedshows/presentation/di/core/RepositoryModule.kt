package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.data.repository.TvTopRatedRepositoryImpl
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedCacheDataSource
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedLocalDataSource
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedRemoteDataSource
import com.arsh.topratedshows.domain.repository.TvTopRatedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTvTopRatedShowRepository(
        tvTopRatedCacheDataSource: TvTopRatedCacheDataSource,
        tvTopRatedLocalDataSource: TvTopRatedLocalDataSource,
        tvTopRatedRemoteDataSource: TvTopRatedRemoteDataSource
    ): TvTopRatedRepository{
        return TvTopRatedRepositoryImpl(tvTopRatedCacheDataSource,tvTopRatedLocalDataSource, tvTopRatedRemoteDataSource)
    }
}