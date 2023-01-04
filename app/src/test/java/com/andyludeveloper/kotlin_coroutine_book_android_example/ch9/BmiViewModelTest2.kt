package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

import com.andyludeveloper.kotlin_coroutine_book_android_example.ch9.fake.FakeBodyInformationRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
internal class BmiViewModelTest2 {
    private lateinit var bmiViewModel: BmiViewModel

    @BeforeEach
    internal fun setUp() {
        val repo = FakeBodyInformationRepository()
        val testDispatcher = StandardTestDispatcher()

        Dispatchers.setMain(testDispatcher)

        bmiViewModel = BmiViewModel(repo, testDispatcher)
    }

    @AfterEach
    internal fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    internal fun bmi() = runTest {
        bmiViewModel.addHeightAndWeight(170, 70)

        bmiViewModel.fetchBMI()
        advanceUntilIdle()

        assertEquals(BMI(170, 70), bmiViewModel.bmi.value)
    }

}
