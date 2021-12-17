package com.example.project1kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project1kotlin.repository.MainRepository
import com.example.project1kotlin.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _postStateFlow: StateFlow<ApiState> = postStateFlow

    init {
        getUsers()
    }

    fun getUsers() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        repository.getUsers()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }

}