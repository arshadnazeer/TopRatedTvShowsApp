package com.arsh.topratedshows.data.repository.datasource

import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.data.model.TvTopRatedList
import retrofit2.Response

interface TvTopRatedRemoteDataSource {
    suspend fun getTvTopRatedShows() : Response<TvTopRatedList>
}