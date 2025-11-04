package com.example.calculator.HomeScreen.domain

sealed class CalculatorEvent {
    data class Number(val number: String) : CalculatorEvent()

    // this his from Db and just update the current display thourght
    data class SetExpression(val expression: String) : CalculatorEvent()

    object Droplast : CalculatorEvent()
    object Delete : CalculatorEvent()

    object Calculate : CalculatorEvent()
    data class Operation(val operation: CalculatorOperation) : CalculatorEvent()

}

sealed class CalculatorOperation(val operator : String) {
    object Add : CalculatorOperation(operator = "+")
    object Subtract : CalculatorOperation(operator = "-")
    object Multiply : CalculatorOperation(operator = "*")

    object Divide : CalculatorOperation(operator = "/")

}

