package com.arsh.topratedshows.presentation.di.tvtoprated

import com.arsh.topratedshows.presentation.topratedshows.TopRatedShowActivity
import dagger.Subcomponent

@TvTopRatedScope
@Subcomponent(modules = [TvTopRatedModule::class])
interface TvTopRatedSubComponent {
    fun inject(tvTopRatedShowActivity: TopRatedShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvTopRatedSubComponent
    }
}