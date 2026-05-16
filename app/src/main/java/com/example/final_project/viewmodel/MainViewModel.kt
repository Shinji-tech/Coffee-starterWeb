package com.example.final_project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.final_project.Repository.MainRepository
import com.example.final_project.domain.BannerModel

class MainViewModel: ViewModel() {
    private val respository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return respository.loadBanner()
    }
}