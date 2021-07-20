package com.arsh.topratedshows.presentation.topratedshows

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arsh.topratedshows.R
import com.arsh.topratedshows.databinding.ActivityTopRatedShowBinding
import com.arsh.topratedshows.presentation.di.Injector
import javax.inject.Inject

class TopRatedShowActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: TopRatedShowViewModelFactory
    private lateinit var binding: ActivityTopRatedShowBinding
    private lateinit var adapter: TvTopRatedShowAdapter
    private lateinit var viewModel: TopRatedShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_top_rated_show)
        (application as Injector).createTvTopRatedComponent()
            .inject(this)

        viewModel = ViewModelProvider(this,viewModelFactory).get(TopRatedShowViewModel::class.java)
     /*   val responseLiveData = viewModel.getTopRatedTvShows()
        responseLiveData.observe(this, Observer {
            Log.e("TAGGG",it.toString())
        })*/
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.topratedRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvTopRatedShowAdapter()
        binding.topratedRecyclerView.adapter = adapter
        displayTvTopRatedShows()
    }

    private fun displayTvTopRatedShows() {
        binding.topratedProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getTopRatedTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.topratedProgressBar.visibility = View.GONE
            } else{
                binding.topratedProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No Data Available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvTopRatedShows()
                true
            } else ->
                super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvTopRatedShows() {
        binding.topratedProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.updateTopRatedTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.topratedProgressBar.visibility = View.GONE
            } else{
                binding.topratedProgressBar.visibility = View.GONE
            }
        })
    }

}