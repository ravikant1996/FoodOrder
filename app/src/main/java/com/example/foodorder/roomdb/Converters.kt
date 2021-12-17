package com.example.foodorder.roomdb

import androidx.room.TypeConverter
import com.example.foodorder.model.Food
import com.google.gson.Gson
import java.util.*

class Converters {
    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun listToJsonString(value: List<Food>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<Food>::class.java).toList()

}