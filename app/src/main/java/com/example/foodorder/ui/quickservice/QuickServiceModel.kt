package com.example.foodorder.ui.quickservice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.model.Food
import com.example.foodorder.model.FoodProvider
import com.example.project1kotlin.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuickServiceModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val foodLiveData = MutableLiveData<Food>()

    val foods: LiveData<Food>
        get() = foodLiveData

    init {
        getFoodList(1)
    }

    fun getFoodList(categoryId: Int): ArrayList<Food> {
        val list: ArrayList<Food> = FoodProvider.data as ArrayList<Food>
        val foodList = ArrayList<Food>()

        list.forEach { i ->
            if (i.categoryId == categoryId) {
//                foodLiveData.value = i
                foodList.add(i)
            }
        }
        return foodList
    }


}