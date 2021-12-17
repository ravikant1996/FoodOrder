package com.example.foodorder.model


import com.google.gson.annotations.SerializedName

data class Pagination(
    val limit: Int,
    val links: Links,
    val page: Int,
    val pages: Int,
    val total: Int
)