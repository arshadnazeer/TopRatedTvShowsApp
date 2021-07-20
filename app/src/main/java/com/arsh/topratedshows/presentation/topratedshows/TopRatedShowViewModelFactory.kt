package com.arsh.topratedshows.presentation.topratedshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arsh.topratedshows.domain.usecase.GetTvTopRatedShowsUseCase
import com.arsh.topratedshows.domain.usecase.UpdatedTvTopRatedShowsUseCase

class TopRatedShowViewModelFactory(
    private val getTvTopRatedShowsUseCase: GetTvTopRatedShowsUseCase,
    private val updatedTvTopRatedShowsUseCase: UpdatedTvTopRatedShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopRatedShowViewModel(getTvTopRatedShowsUseCase,updatedTvTopRatedShowsUseCase) as T
    }
}