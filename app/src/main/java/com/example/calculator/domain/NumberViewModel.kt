package com.example.calculator.domain

import android.util.Log
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

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Calculate -> determineResult()
            is CalculatorEvent.Decimal -> TODO()
            is CalculatorEvent.Delete -> TODO()
            is CalculatorEvent.Number -> {
                enterNum(event.number)
            }

            is CalculatorEvent.Operation -> {
                enterOperator(event.operation)
            }

        }


    }

    private fun enterNum(number: String) {
        if (state.operation == null) {
            state = state.copy(
                number1 = state.number1 + number
            )
        } else {
            state = state.copy(
                number2 = state.number2 + number
            )
        }
    }


    fun enterOperator(symbol: CalculatorOperation) {
        state = state.copy(operation = symbol)
    }

    fun determineResult() {
        val number1 = state.number1.toDoubleOrNull() ?: return
        val number2 = state.number2.toDoubleOrNull() ?: return
        val operation = state.operation ?: return

        val result = when (operation) {
            CalculatorOperation.Add -> number1 + number2
            CalculatorOperation.Subtract -> number1 - number2
            CalculatorOperation.Multiply -> number1 * number2
            CalculatorOperation.Divide -> {
                if (number2 == 0.0) {
                    state = state.copy(
                        result = "Error: Division by zero",
                        number1 = "",
                        number2 = "",
                        operation = null
                    )
                    return
                }
                number1 / number2
            }
        }

        state = state.copy(
            result = result.toString(),
            number1 = result.toString(),
            number2 = "",
            operation = null
        )
    }

}