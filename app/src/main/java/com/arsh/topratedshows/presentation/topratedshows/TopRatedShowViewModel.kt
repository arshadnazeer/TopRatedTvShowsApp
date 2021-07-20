package com.arsh.topratedshows.presentation.topratedshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arsh.topratedshows.domain.usecase.GetTvTopRatedShowsUseCase
import com.arsh.topratedshows.domain.usecase.UpdatedTvTopRatedShowsUseCase

class TopRatedShowViewModel(
    private val getTvTopRatedShowsUseCase: GetTvTopRatedShowsUseCase,
    private val updatedTvTopRatedShowsUseCase: UpdatedTvTopRatedShowsUseCase
) : ViewModel() {

    fun getTopRatedTvShows() = liveData {
        val tvTopRatedShowList = getTvTopRatedShowsUseCase.execute()
        emit(tvTopRatedShowList)
    }

    fun updateTopRatedTvShows() = liveData {
            val tvTopRatedShowList = updatedTvTopRatedShowsUseCase.execute()
            emit(tvTopRatedShowList)
        }
}