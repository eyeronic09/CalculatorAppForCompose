package com.example.calculator.HomeScreen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calculator.HomeScreen.Room.Model.History

@Composable
fun HistoryItem(item: History) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = item.expression)
        Text(text = item.result)
    }
}
