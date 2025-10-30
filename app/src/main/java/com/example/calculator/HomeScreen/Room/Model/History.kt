package com.example.calculator.HomeScreen.Room.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "History_table")
data class History(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val expression : String,
    val result: String
)