package com.example.calculator.HomeScreen.domain

sealed class CalculatorEvent {
    data class Number(val number: String) : CalculatorEvent()

    object droplast : CalculatorEvent()
    object Delete : CalculatorEvent()
    object Decimal : CalculatorEvent()
    object Calculate : CalculatorEvent()
    data class Operation(val operation: CalculatorOperation) : CalculatorEvent()

}

sealed class CalculatorOperation(val operator : String) {
    object Add : CalculatorOperation(operator = "+")
    object Subtract : CalculatorOperation(operator = "-")
    object Multiply : CalculatorOperation(operator = "*")

    object Divide : CalculatorOperation(operator = "/")

}

