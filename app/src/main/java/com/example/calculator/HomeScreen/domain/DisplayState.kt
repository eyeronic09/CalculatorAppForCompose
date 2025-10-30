package com.example.calculator.HomeScreen.domain

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val result: String ="",
    val expression: String = "" ,
    val operation: CalculatorOperation? = null
)