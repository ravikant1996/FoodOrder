package com.example.foodorder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "order")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val transactionId: Int,
    @ColumnInfo(name = "Fool List")
    val food: List<Food>,
    @ColumnInfo(name = "Total Prize")
    val prize: Double,
    val createdDate: Date
)
