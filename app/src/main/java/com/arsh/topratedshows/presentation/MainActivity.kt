package com.arsh.topratedshows.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arsh.topratedshows.R
import com.arsh.topratedshows.databinding.ActivityMainBinding
import com.arsh.topratedshows.presentation.topratedshows.TopRatedShowActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.topRatedButton.setOnClickListener {
            val intent = Intent(this,TopRatedShowActivity::class.java)
            startActivity(intent)
        }
    }
}