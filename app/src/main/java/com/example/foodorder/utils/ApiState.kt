package com.example.project1kotlin.utils

import com.example.foodorder.model.Data
import com.example.foodorder.model.Users


sealed class ApiState {
    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success(val data: Users) : ApiState()
    object Empty : ApiState()
}