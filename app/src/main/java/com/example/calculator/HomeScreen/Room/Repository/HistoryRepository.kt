package com.example.calculator.HomeScreen.Room.Repository

import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.Room.data_socurces.HistorySources
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getAllHistory() : Flow<List<History>>

    suspend fun interExpression(expression: History)

    suspend fun Delete(expression: History)

}