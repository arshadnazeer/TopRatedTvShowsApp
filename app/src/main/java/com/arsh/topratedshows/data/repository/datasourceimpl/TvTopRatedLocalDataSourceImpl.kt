package com.arsh.topratedshows.data.repository.datasourceimpl

import com.arsh.topratedshows.data.db.TvTopRatedDao
import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.data.repository.datasource.TvTopRatedLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvTopRatedLocalDataSourceImpl(
    private val tvTopRatedDao: TvTopRatedDao
) : TvTopRatedLocalDataSource {

    override suspend fun getTvTopRatedShowsFromDB(): List<TvTopRated> {
        return tvTopRatedDao.getTvTopRatedShows()
    }

    override suspend fun updatedTvTopRatedShowsToDB(tvTopRated: List<TvTopRated>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvTopRatedDao.saveTvTopRated(tvTopRated)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvTopRatedDao.deleteAllTopRatedShows()
        }
    }
}