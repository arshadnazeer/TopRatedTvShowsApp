package com.arsh.topratedshows.presentation.topratedshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arsh.topratedshows.R
import com.arsh.topratedshows.data.model.TvTopRated
import com.arsh.topratedshows.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvTopRatedShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val topRatedShowList = ArrayList<TvTopRated>()

    fun setList(tvTopRated: List<TvTopRated>){
        topRatedShowList.clear()
        topRatedShowList.addAll(tvTopRated)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(topRatedShowList[position])
    }

    override fun getItemCount(): Int {
        return topRatedShowList.size
    }
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvTopRated: TvTopRated){
        binding.titleTextView.text = tvTopRated.name
        binding.descriptionTextView.text = tvTopRated.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvTopRated.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}