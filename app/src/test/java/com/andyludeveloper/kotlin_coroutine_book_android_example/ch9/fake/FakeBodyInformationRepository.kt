package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9.fake

import com.andyludeveloper.kotlin_coroutine_book_android_example.ch9.BodyInformationRepository
import kotlinx.coroutines.*
import kotlin.math.*

class FakeBodyInformationRepository : BodyInformationRepository {
    private val heights: MutableList<Int> = mutableListOf()
    private val weights: MutableList<Int> = mutableListOf()
 
    override suspend fun getHeight(): Int {
        delay(1000)
        return heights.average().roundToInt()
    }
 
    override suspend fun setHeight(height: Int) {
        delay(10)
        heights.add(height)
    }
 
    override suspend fun getWeight(): Int {
        delay(100)
        return weights.average().roundToInt()
    }
 
    override suspend fun setWeight(weight: Int) {
        delay(10)
        weights.add(weight)
    }
}
