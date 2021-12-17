package com.example.foodorder.ui.transaction

import androidx.lifecycle.ViewModel
import com.example.foodorder.model.Transaction
import com.example.project1kotlin.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderHistoryModel @Inject constructor(private val repository: MainRepository) : ViewModel() {


    suspend fun getTransAction() {
        repository.getTransAction()
    }

    suspend fun addOrder(arr: ArrayList<Transaction>) {
        repository.addOrder(arr)
    }

}