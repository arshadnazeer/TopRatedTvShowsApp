package com.arsh.topratedshows.presentation.di.core

import com.arsh.topratedshows.domain.repository.TvTopRatedRepository
import com.arsh.topratedshows.domain.usecase.GetTvTopRatedShowsUseCase
import com.arsh.topratedshows.domain.usecase.UpdatedTvTopRatedShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetTvTopRatedShowUseCase(tvTopRatedRepository: TvTopRatedRepository): GetTvTopRatedShowsUseCase{
        return GetTvTopRatedShowsUseCase(tvTopRatedRepository)
    }

    @Provides
    fun providesUpdateTvTopRatedShowUseCase(tvTopRatedRepository: TvTopRatedRepository): UpdatedTvTopRatedShowsUseCase{
        return UpdatedTvTopRatedShowsUseCase(tvTopRatedRepository)
    }
}