package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

import com.andyludeveloper.kotlin_coroutine_book_android_example.ch9.fake.FakeBodyInformationRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class BmiViewModelTest {

    @Test
    internal fun bmi() = runTest {
        val repo = FakeBodyInformationRepository()
        val testDispatcher = StandardTestDispatcher()

        val bmiViewModel = BmiViewModel(repo, testDispatcher)
        bmiViewModel.addHeightAndWeight(170, 70)
        bmiViewModel.fetchBMI()

        advanceUntilIdle()

        assertEquals(BMI(170, 70), bmiViewModel.bmi.value)
    }

}
