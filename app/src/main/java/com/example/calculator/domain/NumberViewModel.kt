package com.example.calculator.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorEvent
import com.example.calculator.HomeScreen.CalculatorState

class NumberViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onEvent(calculatorEvent : CalculatorEvent){
        when(calculatorEvent){
           is CalculatorEvent.Calculate -> TODO()
           is CalculatorEvent.Decimal -> TODO()
           is CalculatorEvent.Delete -> TODO()
            is CalculatorEvent.Number -> {enterNumber(calculatorEvent.number.toString())}
            is CalculatorEvent.Operation -> TODO()

        }


    }

    private fun enterNumber(numbers: String) {
        if (state.operation == null) {
            state = state.copy(
                number1 = state.number1 + numbers
            )
        }

        if(state.operation != null){
            state = state.copy(
                number2 = state.number2 + numbers
            )

        }
    }

}