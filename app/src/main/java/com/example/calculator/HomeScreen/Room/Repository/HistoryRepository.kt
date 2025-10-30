package com.example.calculator.HomeScreen.Room.Repository

import com.example.calculator.HomeScreen.Room.Model.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getAllHistory() : Flow<List<History>>

}