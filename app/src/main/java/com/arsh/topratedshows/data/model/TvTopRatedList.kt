package com.arsh.topratedshows.data.model
import com.arsh.topratedshows.data.model.TvTopRated
import com.google.gson.annotations.SerializedName

data class TvTopRatedList(

    @SerializedName("results")
    val tvTopRateds: List<TvTopRated>,

    )
