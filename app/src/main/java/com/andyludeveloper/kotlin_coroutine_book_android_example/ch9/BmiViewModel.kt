package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class BmiViewModel(
    private val repo: BodyInformationRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _bmi: MutableStateFlow<BMI> = MutableStateFlow(BMI(0, 0))
    val bmi: StateFlow<BMI> = _bmi

    fun fetchBMI() {
        viewModelScope.launch {
            val calculateBMIUseCase = CalculateBMIUseCase(repo, ioDispatcher)
            _bmi.value = calculateBMIUseCase()
        }
    }

    fun addHeightAndWeight(height: Int, weight: Int) {
        viewModelScope.launch {
            repo.setHeight(height)
            repo.setWeight(weight)
        }
    }
}