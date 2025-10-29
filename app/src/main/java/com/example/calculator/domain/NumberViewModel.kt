package com.example.calculator.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation
import com.example.calculator.HomeScreen.CalculatorState
import com.example.calculator.HomeScreen.previs
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class NumberViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> enterNum(event.number)
            is CalculatorEvent.Operation -> enterOperator(event.operation)
            is CalculatorEvent.Calculate -> determineResult()
            is CalculatorEvent.Delete -> clearState()
            CalculatorEvent.droplast -> removeLast()
            else -> Unit
        }
    }

    private fun enterNum(number: String) {
        _state.update { current ->
            when {
                // After a result, if user starts typing a new number, start a new expression
                current.result.isNotEmpty() && current.operation == null -> current.copy(
                    number1 = number,
                    expression = number,
                    result = ""
                )

                // Before any operator
                current.operation == null -> current.copy(
                    number1 = current.number1 + number,
                    expression = current.expression + number,
                    result = ""
                )

                // After operator — editing number2
                else -> current.copy(
                    number2 = current.number2 + number,
                    expression = current.expression + number
                )
            }
        }
    }

    private fun enterOperator(symbol: CalculatorOperation) {
        _state.update { current ->
            val endsWithNumber = current.expression.lastOrNull()?.isDigit() == true

            if (!endsWithNumber) return@update current // avoid double operator

            // If there’s a pending operation and number2 exists → compute intermediate result
            if (current.operation != null && current.number2.isNotEmpty()) {
                val number1 = current.number1.toDoubleOrNull() ?: 0.0
                val number2 = current.number2.toDoubleOrNull() ?: 0.0
                val result = when (current.operation) {
                    is CalculatorOperation.Add -> number1 + number2
                    is CalculatorOperation.Subtract -> number1 - number2
                    is CalculatorOperation.Multiply -> number1 * number2
                    is CalculatorOperation.Divide -> if (number2 == 0.0) null else number1 / number2
                }

                if (result != null) {
                    current.copy(
                        number1 = result.toString(),
                        number2 = "",
                        operation = symbol,
                        // Keep appending operator to expression — maintain history
                        expression = current.expression + symbol.operator,
                        result = result.toString()
                    )
                } else {
                    current.copy(result = "Error", operation = null)
                }
            } else {
                // First operator or after result
                current.copy(
                    operation = symbol,
                    expression = current.expression + symbol.operator
                )
            }
        }
    }

    private fun determineResult() {
        val current = _state.value
        val number1 = current.number1.toDoubleOrNull()
        val number2 = current.number2.toDoubleOrNull()

        if (number1 == null || number2 == null || current.operation == null) return

        val result = when (current.operation) {
            is CalculatorOperation.Add -> number1 + number2
            is CalculatorOperation.Subtract -> number1 - number2
            is CalculatorOperation.Multiply -> number1 * number2
            is CalculatorOperation.Divide -> if (number2 == 0.0) null else number1 / number2
        }

        if (result != null) {
            _state.update {
                it.copy(
                    number1 = result.toString(),
                    number2 = "",
                    operation = null,
                    // 👇 KEEP the expression (don’t override it)
                    expression = it.expression,
                    result = result.toString()
                )
            }
        } else {
            _state.update {
                it.copy(result = "Error", operation = null)
            }
        }
    }

    private fun removeLast() {
        _state.update { current ->
            if (current.expression.isEmpty()) return@update current
            val newExpression = current.expression.dropLast(1)

            when {
                current.number2.isNotEmpty() -> current.copy(
                    number2 = current.number2.dropLast(1),
                    expression = newExpression,
                    result = ""
                )

                current.operation != null -> current.copy(
                    operation = null,
                    expression = newExpression,
                    result = ""
                )

                current.number1.isNotEmpty() -> current.copy(
                    number1 = current.number1.dropLast(1),
                    expression = newExpression,
                    result = ""
                )

                else -> current
            }
        }
    }

    private fun clearState() {
        _state.update {
            it.copy(
                number1 = "",
                number2 = "",
                result = "",
                operation = null,
                expression = ""
            )
        }
    }
}
