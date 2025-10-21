package com.example.calculator

sealed class CalculatorEvent {
    data class Number(val number: String) : CalculatorEvent()
    object Delete : CalculatorEvent()
    object Decimal : CalculatorEvent()
    object Calculate : CalculatorEvent()
    data class Operation(val operation: CalculatorOperation) : CalculatorEvent()

}

sealed class CalculatorOperation(val operator : String) {
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("*")

    object Divide : CalculatorOperation("/")

}

