package com.example.project1kotlin.network

import com.example.foodorder.model.Data
import com.example.foodorder.model.Users
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsers(): Users = apiService.getUsers()
}