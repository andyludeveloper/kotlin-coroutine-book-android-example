package com.andyludeveloper.kotlin_coroutine_book_android_example.ch9

import kotlin.math.pow

data class BMI(val height: Int, val weight: Int) {
    operator fun invoke(): Double = weight / (height / 100.0).pow(2)
}
