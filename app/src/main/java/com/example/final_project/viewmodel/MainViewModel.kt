package com.example.final_project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.final_project.Repository.MainRepository
import com.example.final_project.domain.BannerModel
import com.example.final_project.domain.CategoryModel

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }
}
