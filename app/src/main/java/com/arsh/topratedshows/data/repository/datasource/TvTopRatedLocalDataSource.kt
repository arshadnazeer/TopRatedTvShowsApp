package com.arsh.topratedshows.data.repository.datasource

import com.arsh.topratedshows.data.model.TvTopRated

interface TvTopRatedLocalDataSource {
    suspend fun getTvTopRatedShowsFromDB() : List<TvTopRated>
    suspend fun updatedTvTopRatedShowsToDB(tvTopRated: List<TvTopRated>)
    suspend fun clearAll()
}