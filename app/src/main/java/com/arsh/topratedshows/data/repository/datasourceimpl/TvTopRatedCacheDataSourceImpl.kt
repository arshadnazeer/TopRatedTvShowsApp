package com.arsh.topratedshows.data.repository.datasourceimpl

import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedCacheDataSource

class TvTopRatedCacheDataSourceImpl : TvTopRatedCacheDataSource {
    private var tvTopRatedList = ArrayList<TvTopRated>()
    override suspend fun getTvTopRatedShowsFromCache(): List<TvTopRated> {
        return tvTopRatedList
    }

    override suspend fun updateTvTopRatedShowsFromCache(tvTopRated: List<TvTopRated>) {
        tvTopRatedList.clear()
        tvTopRatedList = ArrayList(tvTopRated)
    }
}