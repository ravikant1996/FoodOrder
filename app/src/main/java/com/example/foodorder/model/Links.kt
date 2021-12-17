package com.example.foodorder.model


import com.google.gson.annotations.SerializedName

data class Links(
    val current: String,
    val next: String,
    val previous: Any
)