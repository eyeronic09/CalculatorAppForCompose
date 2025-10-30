package com.example.calculator.HomeScreen.Room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.calculator.HomeScreen.Room.Model.History
import kotlinx.coroutines.flow.Flow


@Dao
interface HistoryDao {


    @Query("SELECT * from history_table ")
    fun getAllHistory (): Flow<List<History>>


}