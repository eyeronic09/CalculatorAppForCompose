package com.example.calculator.HomeScreen.Room.Repository

import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.Room.data_socurces.HistorySources
import com.example.calculator.HomeScreen.Room.data_socurces.RoomDataSources
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl (private val dataSources: HistorySources ) : HistoryRepository{
    override suspend fun getAllHistory(): Flow<List<History>> {
       return dataSources.getAllHistory()
    }
}