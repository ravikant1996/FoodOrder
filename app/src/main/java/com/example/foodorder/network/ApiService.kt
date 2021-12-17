package com.example.project1kotlin.network

import com.example.foodorder.model.Data
import com.example.foodorder.model.Users
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Users

}