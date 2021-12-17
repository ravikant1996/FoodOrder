package com.example.lifecycleaware.retrofitseriesmvvm.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodorder.model.Food
import com.example.foodorder.model.Transaction

@Dao
interface FoodDao {

    @Insert
    suspend fun addQuote(quotes: ArrayList<Transaction>)

    @Query("Select * from `order`")
    suspend fun getOrders(): List<Transaction>
}