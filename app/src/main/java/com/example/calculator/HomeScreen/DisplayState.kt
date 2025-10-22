package com.example.calculator.HomeScreen

import com.example.calculator.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val result: String ="",
    val operation: CalculatorOperation? = null
)