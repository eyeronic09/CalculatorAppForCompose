package com.example.calculator.HomeScreen.Room.data_socurces

import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.Room.dao.HistoryDao
import kotlinx.coroutines.flow.Flow

class RoomDataSources(private val dao : HistoryDao) : HistorySources {
    override suspend fun getAllHistory(): Flow<List<History>> {
       return dao.getAllHistory()
    }

    override suspend fun insertExpression(expression: History) {
        return dao.insterExperssion(expression)
    }

}