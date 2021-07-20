package com.arsh.topratedshows.presentation.di

import com.arsh.topratedshows.presentation.di.tvtoprated.TvTopRatedSubComponent

interface Injector {
    fun createTvTopRatedComponent(): TvTopRatedSubComponent
}