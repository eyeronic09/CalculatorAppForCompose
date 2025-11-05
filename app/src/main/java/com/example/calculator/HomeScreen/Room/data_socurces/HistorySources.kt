package com.example.calculator.HomeScreen.Room.data_socurces

import com.example.calculator.HomeScreen.Room.Model.History
import kotlinx.coroutines.flow.Flow

interface HistorySources {
    suspend fun getAllHistory() : Flow<List<History>>
    suspend fun insertExpression(expression : History)

    suspend fun Delete(expression: History)
}