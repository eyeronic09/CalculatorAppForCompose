package com.example.calculator.HistoryScreen.domain

import com.example.calculator.HomeScreen.domain.CalculatorState

sealed class HistoryEvent {
    data class currentHistoryUpdateToState(val state: CalculatorState): HistoryEvent()
    object deleteHistory : HistoryEvent()
}