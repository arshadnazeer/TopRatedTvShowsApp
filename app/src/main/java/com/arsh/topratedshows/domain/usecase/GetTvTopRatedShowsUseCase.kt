package com.arsh.topratedshows.domain.usecase

import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.domain.repository.TvTopRatedRepository

class GetTvTopRatedShowsUseCase(private val tvTopRatedRepository: TvTopRatedRepository) {
    suspend fun execute():List<TvTopRated>? = tvTopRatedRepository.getTvTopRatedShows()
}