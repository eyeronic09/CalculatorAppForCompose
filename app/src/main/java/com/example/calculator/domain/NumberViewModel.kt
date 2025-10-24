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
            is CalculatorEvent.Calculate -> determineResult()
            is CalculatorEvent.Decimal -> TODO()
            is CalculatorEvent.Delete -> {
                clearState()
            }
            is CalculatorEvent.Number -> {
                enterNum(event.number)
            }

            is CalculatorEvent.Operation -> {
                enterOperator(event.operation)
            }

        }


    }

    private fun clearState()  {
        _state.update { it ->
            it.copy(
                number1 = "",
                number2 = "",
                result = "",
                operation = null
            )
        }

    }

    private fun enterNum(number: String) {
        _state.update { currentState ->
            Log.d("currentState" , currentState.toString())
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

    private fun determineResult(){
        val number1 = _state.value.number1.toDoubleOrNull() ?: 0.0
        val number2 = _state.value.number2.toDoubleOrNull() ?: 0.0
        val result =  when(_state.value.operation){
            is CalculatorOperation.Add -> {
                number1 + number2
            }
            is CalculatorOperation.Divide -> {
                if (number2 == 0.0) {
                    null
                } else {
                    number1 / number2
                }
            }
            is CalculatorOperation.Multiply -> {
                number1 * number2
            }
            is CalculatorOperation.Subtract -> {
                number1 - number2
            }
            null -> null
        }
        _state.update { calculatorState ->
            calculatorState.copy(
                result = result.toString()
            )

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