package com.example.final_project.activities

import android.R
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.final_project.databinding.ActivityMainBinding
import com.example.final_project.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
    }

    private fun initBanner() {
        binding.apply{
            progressBarBanner.visibility = View.VISIBLE
            viewModel.loadBanner().observeForever {
                Glide.with(this@MainActivity)
                    .load(it[0].url)
                    .into(banner)
                progressBarBanner.visibility = View.GONE
            }
            viewModel.loadBanner()
        }
    }

}
