package com.example.calculator.HistoryScreen.domain

import com.example.calculator.HomeScreen.Room.Model.History
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HistoryState(
    val historyList: List<History> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)