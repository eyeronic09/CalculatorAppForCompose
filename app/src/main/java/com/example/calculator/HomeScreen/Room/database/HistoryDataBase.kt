package com.example.calculator.HomeScreen.Room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.Room.dao.HistoryDao

@Database(
    entities = [History::class],
    exportSchema = false,
    version = 1
)
abstract class HistoryDataBase: RoomDatabase(){
    abstract fun HistoryDao (): HistoryDao

    companion object {
        @Volatile
        private var INSTANCES : HistoryDataBase? = null
        fun getDatabase(context: Context) : HistoryDataBase {
            return INSTANCES ?: synchronized(this){
                val instances = Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = HistoryDataBase::class.java,
                    name = "History_database"
                ).build()
                INSTANCES = instances
                instances
            }
        }

    }
}