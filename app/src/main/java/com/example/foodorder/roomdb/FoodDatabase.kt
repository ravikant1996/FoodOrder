package com.example.lifecycleaware.retrofitseriesmvvm.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodorder.model.Transaction
import com.example.foodorder.roomdb.Converters

@Database(entities = [Transaction::class], version = 1)
@TypeConverters(Converters::class)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}