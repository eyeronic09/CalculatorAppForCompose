package com.example.calculator.HistoryScreen.Ui_Layer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.calculator.HistoryScreen.domain.HistoryViewModel
import com.example.calculator.HistoryScreen.component.HistoryItem
import com.example.calculator.HistoryScreen.domain.HistoryEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = koinViewModel(), NavController: NavHostController , initial_Expression : String) {
    val state by viewModel.historyUiState.collectAsStateWithLifecycle()
    Scaffold() { PaddingValues ->
        LazyColumn(modifier = Modifier.padding(PaddingValues)) {
            items(items = state.historyList) { item ->
                HistoryItem(
                    item,
                    onDelete = {},
                    onStateUpdate = {
                        NavController.navigate(item.expression)
                    }
                )
            }

        }

    }


}


@Preview(showSystemUi = true)
@Composable
private fun Pris() {

    HistoryScreen(NavController = rememberNavController() , initial_Expression = "e")
}


