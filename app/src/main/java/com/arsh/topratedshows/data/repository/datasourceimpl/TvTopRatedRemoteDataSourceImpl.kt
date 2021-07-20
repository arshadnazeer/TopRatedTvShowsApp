package com.arsh.topratedshows.data.repository.datasourceimpl

import com.arsh.topratedshows.data.api.TMDBService
import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.data.model.TvTopRatedList
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedRemoteDataSource
import retrofit2.Response

class TvTopRatedRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey : String
    ) :  TvTopRatedRemoteDataSource{

    override suspend fun getTvTopRatedShows(): Response<TvTopRatedList> {
        return tmdbService.getTvTopRated(apikey)
    }

}