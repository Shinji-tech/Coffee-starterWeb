package com.example.final_project.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.final_project.databinding.ActivityMainBinding
import com.example.final_project.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
    }

    private fun initBanner() {
        binding.apply {
            progressBarBanner.visibility = View.VISIBLE
            viewModel.loadBanner().observe(this@MainActivity) { list ->
                if (list.isNotEmpty()) {
                    Glide.with(this@MainActivity)
                        .load(list[0].url)
                        .into(banner)
                    progressBarBanner.visibility = View.GONE

                }
                viewModel.loadBanner()
            }
        }
    }
}
