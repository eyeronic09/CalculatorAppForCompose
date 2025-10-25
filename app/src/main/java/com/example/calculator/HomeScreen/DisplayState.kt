package com.example.calculator.HomeScreen

import androidx.compose.runtime.mutableStateListOf
import com.example.calculator.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val result: String ="",
    val expression: String = "" ,
  //  var expression: MutableList<String> = mutableListOf<String>(),

    val operation: CalculatorOperation? = null
)