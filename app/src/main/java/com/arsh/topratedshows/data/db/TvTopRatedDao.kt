package com.arsh.topratedshows.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arsh.topratedshows.data.model.TvTopRated

@Dao
interface TvTopRatedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvTopRated(tvTopRated: List<TvTopRated>)

    @Query("DELETE FROM tv_top_rated")
    suspend fun deleteAllTopRatedShows()

    @Query("SELECT * FROM tv_top_rated")
    suspend fun getTvTopRatedShows(): List<TvTopRated>
}