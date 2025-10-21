package com.example.calculator.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation
import com.example.calculator.HomeScreen.CalculatorState

class NumberViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    fun onEvent(calculatorEvent: CalculatorEvent) {
        when (calculatorEvent) {
            is CalculatorEvent.Calculate -> determineResult()
            is CalculatorEvent.Decimal -> TODO()
            is CalculatorEvent.Delete -> TODO()
            is CalculatorEvent.Number -> {
                enterNumber(numbers = calculatorEvent.number)
            }

            is CalculatorEvent.Operation -> {
                enterOperator(calculatorEvent.operation)
            }

        }


    }

    fun enterNumber(numbers: String) {
        state = if (state.operation == null) {
            state.copy(
                number1 = state.number1 + numbers
            )
        }else{
            state.copy(
                number2 = state.number2 +  numbers
            )
        }
    }

    fun enterOperator(symbol: CalculatorOperation) {
        state = state.copy(operation = symbol)
    }


    fun determineResult() {
        val number1 = state.number1.toDoubleOrNull() ?: 0.0
        val number2 = state.number2.toDoubleOrNull() ?: 0.0


            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Divide -> {
                    if (number2 == 0.0) {
                        throw ArithmeticException("Cannot divide by zero")
                    }
                    number1 / number2
                }

                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Subtract -> number1 - number2
                null -> throw IllegalStateException("Cannot calculate result without operation")
            }
            state = state.copy(
                number1 = result.toString(),
                number2 = "",
                operation = null
            )






    }
}