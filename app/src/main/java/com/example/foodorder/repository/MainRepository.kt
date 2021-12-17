package com.example.project1kotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodorder.model.*
import com.example.lifecycleaware.retrofitseriesmvvm.roomdb.FoodDao
import com.example.project1kotlin.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiServiceImpl: ApiServiceImpl,
    private val foodDao: FoodDao
) {

    fun getUsers(): Flow<Users> = flow {
        emit(apiServiceImpl.getUsers())
    }.flowOn(Dispatchers.IO)


    suspend fun getTransAction() {
        foodDao.getOrders()
    }

    suspend fun addOrder(arr: ArrayList<Transaction>) {
        foodDao.addQuote(arr)
    }
}