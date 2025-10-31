package com.example.calculator.HistoryScreen.Ui_Layer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.calculator.HistoryScreen.domain.HistoryViewModel
import com.example.calculator.HomeScreen.Room.Model.History
import com.example.calculator.HomeScreen.component.HistoryItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = koinViewModel(), navHost : NavHostController) {
    val state by viewModel.historyState.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = state.historyList){ item ->
            HistoryItem(item)
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun Pris() {

    HistoryScreen(navHost = rememberNavController())
}


