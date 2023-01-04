package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class CalculateBMIUseCase(
    private val repo: BodyInformationRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend operator fun invoke(): BMI = coroutineScope {
        println("invoke(): ${Thread.currentThread().name}")
        val height = async(ioDispatcher) { repo.getHeight() }
        val weight = async(ioDispatcher) { repo.getWeight() }

        BMI(
            height.await(),
            weight.await(),
//                gender.await()
        )
    }

    suspend fun invoke2(): BMI =
        coroutineScope {
            println("invoke2: ${Thread.currentThread().name}")
            val height = async { repo.getHeight() }
            val weight = async { repo.getWeight() }
//            val gender = async { repo.getGender() }

            BMI(
                height.await(),
                weight.await(),
//                gender.await()
            )
        }
}