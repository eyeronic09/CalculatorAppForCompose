package com.example.calculator.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation
import com.example.calculator.HomeScreen.CalculatorState
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NumberViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state : StateFlow<CalculatorState> = _state.asStateFlow()


    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Calculate -> TODO()
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
        _state.update { currentState ->
            if (currentState.operation == null){
                currentState.copy(
                    number1 = currentState.number1 + number
                )
            }else {
                currentState.copy(
                    number2 = currentState.number2 + number
                )
            }

        }
    }


    fun enterOperator(symbol: CalculatorOperation) {
        _state.update { currentState ->
            if (currentState.number1.isNotBlank()){
                currentState.copy(operation = symbol)
            }else {
                currentState
            }

        }
    }

}