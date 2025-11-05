package com.example.calculator.HistoryScreen.domain

import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.domain.CalculatorState

sealed class HistoryEvent {
    data class deleteHistory(val expression : History) : HistoryEvent()

}