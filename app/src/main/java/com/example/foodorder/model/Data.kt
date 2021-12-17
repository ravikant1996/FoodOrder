package com.example.foodorder.model


import com.google.gson.annotations.SerializedName

data class Data(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
)