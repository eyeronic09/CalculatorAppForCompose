package com.example.calculator.HomeScreen.domain

import androidx.lifecycle.ViewModel
import com.example.calculator.HomeScreen.Room.Repository.HistoryRepository
import com.notkamui.keval.Keval
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class NumberViewModel(
    private val repository: HistoryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> append(event.number)
            is CalculatorEvent.Operation -> append(event.operation.operator)
            is CalculatorEvent.Calculate -> calculate()
            is CalculatorEvent.Delete -> clear()
            is CalculatorEvent.droplast -> removeLast()
            else -> Unit
        }
    }

    private fun append(symbol: String) {
        _state.update {
            it.copy(expression = it.expression + symbol)
        }
    }

    private fun calculate() {
        _state.update { current ->
            try {
                val value = Keval.eval(current.expression)
                current.copy(result = value.toString())
            } catch (e: Exception) {
                current.copy(result = "Error")
            }
        }
    }

    private fun removeLast() {
        _state.update {
            if (it.expression.isNotEmpty()) {
                it.copy(expression = it.expression.dropLast(1))
            } else it
        }
    }

    private fun clear() {
        _state.update { CalculatorState() }
    }
}