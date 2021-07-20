package com.arsh.topratedshows.data.api

import com.arsh.topratedshows.data.model.TvTopRatedList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("tv/top_rated")
    suspend fun getTvTopRated(@Query("api_key")apikey:String) : Response<TvTopRatedList>

}