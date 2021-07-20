package com.arsh.topratedshows.presentation.di.tvtoprated

import com.arsh.topratedshows.domain.usecase.GetTvTopRatedShowsUseCase
import com.arsh.topratedshows.domain.usecase.UpdatedTvTopRatedShowsUseCase
import com.arsh.topratedshows.presentation.topratedshows.TopRatedShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvTopRatedModule {
    @TvTopRatedScope
    @Provides
    fun provideTvTopRatedViewModelFactory(
        getTvTopRatedShowsUseCase: GetTvTopRatedShowsUseCase,
        updatedTvTopRatedShowsUseCase: UpdatedTvTopRatedShowsUseCase
    ) : TopRatedShowViewModelFactory {
        return TopRatedShowViewModelFactory(getTvTopRatedShowsUseCase,updatedTvTopRatedShowsUseCase)
    }
}