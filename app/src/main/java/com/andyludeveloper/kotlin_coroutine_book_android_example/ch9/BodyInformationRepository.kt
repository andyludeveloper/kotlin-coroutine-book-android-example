package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

interface BodyInformationRepository {
    suspend fun getHeight(): Int

    suspend fun setHeight(height: Int)

    suspend fun getWeight(): Int

    suspend fun setWeight(weight: Int)
}