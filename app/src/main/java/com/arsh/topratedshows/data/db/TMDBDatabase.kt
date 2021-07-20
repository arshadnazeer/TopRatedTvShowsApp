package com.arsh.topratedshows.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arsh.topratedshows.data.model.TvTopRated

@Database(entities = [TvTopRated::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun tvTopRatedDao(): TvTopRatedDao
}