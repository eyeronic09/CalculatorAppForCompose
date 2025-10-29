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
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.notkamui.keval.Keval

class NumberViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    private val keval = Keval

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> enterNum(event.number)
            is CalculatorEvent.Operation -> enterOperator(event.operation)
            is CalculatorEvent.Calculate -> determineResult()
            is CalculatorEvent.Delete -> clearState()
            is CalculatorEvent.droplast -> removeLast()
            else -> Unit
        }
    }

    private fun enterNum(number: String) {
        _state.update { current ->
            when {
                current.result.isNotEmpty() && current.operation == null -> current.copy(
                    number1 = number,
                    expression = number,
                    result = ""
                )
                current.operation == null -> current.copy(
                    number1 = current.number1 + number,
                    expression = current.expression + number,
                    result = ""
                )
                else -> current.copy(
                    number2 = current.number2 + number,
                    expression = current.expression + number
                )
            }.also { newState ->
                // Update result in real-time
                updateResult(newState)
            }
        }
    }

    private fun enterOperator(symbol: CalculatorOperation) {
        _state.update { current ->
            val endsWithNumber = current.expression.lastOrNull()?.isDigit() == true
            if (!endsWithNumber) return@update current

            current.copy(
                operation = symbol,
                expression = current.expression + symbol.operator
            ).also { newState ->
                // Update result in real-time
                updateResult(newState)
            }
        }
    }

    private fun determineResult() {
        _state.update { current ->
            try {
                val result = keval.eval(current.expression).toDouble()
                current.copy(
                    number1 = result.toString(),
                    number2 = "",
                    operation = null,
                    expression = current.expression,
                    result = result.toString()
                )
            } catch (e: Exception) {
                current.copy(result = "Error")
            }
        }
    }

    private fun removeLast() {
        _state.update { current ->
            if (current.expression.isEmpty()) return@update current
            val newExpression = current.expression.dropLast(1)

            val newState = when {
                current.number2.isNotEmpty() -> current.copy(
                    number2 = current.number2.dropLast(1).takeIf { it.isNotEmpty() } ?: "",
                    expression = newExpression
                )
                current.operation != null -> current.copy(
                    operation = null,
                    expression = newExpression
                )
                current.number1.isNotEmpty() -> current.copy(
                    number1 = current.number1.dropLast(1).takeIf { it.isNotEmpty() } ?: "",
                    expression = newExpression
                )
                else -> current
            }

            updateResult(newState)
            newState
        }
    }

    private fun updateResult(state: CalculatorState) {
        try {
            if (state.expression.isNotEmpty()) {
                val result = keval.eval(state.expression).toDouble()
                _state.update { it.copy(result = result.toString()) }
            } else {
                _state.update { it.copy(result = "") }
            }
        } catch (e: Exception) {
            _state.update { it.copy(result = "") }
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