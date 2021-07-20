package com.arsh.topratedshows.data.repository.datasource

import com.arsh.topratedshows.data.model.TvTopRated

interface TvTopRatedCacheDataSource {
    suspend fun getTvTopRatedShowsFromCache() : List<TvTopRated>
    suspend fun updateTvTopRatedShowsFromCache(tvTopRated: List<TvTopRated>)
}