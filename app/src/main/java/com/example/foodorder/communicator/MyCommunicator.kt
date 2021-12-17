package com.example.foodorder.communicator

import com.example.foodorder.model.Food


interface MyCommunicator { // Meant for inter-fragment communication
    fun cart(food: Food)
}
