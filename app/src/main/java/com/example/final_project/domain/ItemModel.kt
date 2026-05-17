package com.example.final_project.domain

import java.io.Serializable

data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberOfCart: Int = 0,
    var extra: String = "",

    ) : Serializable
