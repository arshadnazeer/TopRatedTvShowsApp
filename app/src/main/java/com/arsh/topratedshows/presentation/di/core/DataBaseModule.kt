package com.arsh.topratedshows.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.arsh.topratedshows.data.db.TMDBDatabase
import com.arsh.topratedshows.data.db.TvTopRatedDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesDataBase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideTvTopRatedShowsDao(tmdbDatabase: TMDBDatabase):TvTopRatedDao{
        return tmdbDatabase.tvTopRatedDao()
    }
}