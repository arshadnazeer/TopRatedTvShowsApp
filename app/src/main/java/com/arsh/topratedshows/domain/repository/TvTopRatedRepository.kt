package com.arsh.topratedshows.domain.repository

import com.arsh.topratedshows.data.model.TvTopRated

interface TvTopRatedRepository {
    suspend fun getTvTopRatedShows():List<TvTopRated>?
    suspend fun updateTvTopRatedShows(): List<TvTopRated>?
}