package com.arsh.topratedshows.data.repository

import android.util.Log
import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedCacheDataSource
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedLocalDataSource
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedRemoteDataSource
import com.arsh.topratedshows.domain.repository.TvTopRatedRepository
import java.lang.Exception

class TvTopRatedRepositoryImpl(
    private val tvTopRatedCacheDataSource: TvTopRatedCacheDataSource,
    private val tvTopRatedLocalDataSource: TvTopRatedLocalDataSource,
    private val tvTopRatedRemoteDataSource: TvTopRatedRemoteDataSource
) : TvTopRatedRepository {

    override suspend fun getTvTopRatedShows(): List<TvTopRated>? {
        return getDataFromCache()
    }

    override suspend fun updateTvTopRatedShows(): List<TvTopRated>? {
        val newTvTopRatedList  = getDataFromAPI()
        tvTopRatedLocalDataSource.clearAll()
        tvTopRatedLocalDataSource.updatedTvTopRatedShowsToDB(newTvTopRatedList)
        tvTopRatedCacheDataSource.updateTvTopRatedShowsFromCache(newTvTopRatedList)
        return newTvTopRatedList
    }

    suspend fun getDataFromAPI() : List<TvTopRated>{
        lateinit var tvTopRatedList : List<TvTopRated>
        try {
            val response = tvTopRatedRemoteDataSource.getTvTopRatedShows()
            val body = response.body()
            if (body!=null){
                tvTopRatedList = body.tvTopRateds
            }

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }
        return tvTopRatedList
    }


    suspend fun getDataFromDB() : List<TvTopRated>{
        lateinit var tvTopRatedList : List<TvTopRated>
        try {
            tvTopRatedList = tvTopRatedLocalDataSource.getTvTopRatedShowsFromDB()

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (tvTopRatedList.size>0){
            return tvTopRatedList
        } else
            tvTopRatedList = getDataFromAPI()
            tvTopRatedLocalDataSource.updatedTvTopRatedShowsToDB(tvTopRatedList)

        return tvTopRatedList
    }


    suspend fun getDataFromCache() : List<TvTopRated>{
        lateinit var tvTopRatedList : List<TvTopRated>
        try {
            tvTopRatedList = tvTopRatedCacheDataSource.getTvTopRatedShowsFromCache()

        }catch (e: Exception){
            Log.e("TAGGG",e.message.toString())
        }

        if (tvTopRatedList.size>0){
            return tvTopRatedList
        } else
            tvTopRatedList = getDataFromDB()
            tvTopRatedCacheDataSource.updateTvTopRatedShowsFromCache(tvTopRatedList)

        return tvTopRatedList
    }
}