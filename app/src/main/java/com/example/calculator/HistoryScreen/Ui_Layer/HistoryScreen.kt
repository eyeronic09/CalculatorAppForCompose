package com.example.calculator.HistoryScreen.Ui_Layer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.calculator.Core_NavScreen.Screen
import com.example.calculator.HistoryScreen.component.HistoryItem
import com.example.calculator.HistoryScreen.domain.HistoryEvent
import com.example.calculator.HistoryScreen.domain.HistoryState
import com.example.calculator.HistoryScreen.domain.HistoryViewModel
import org.koin.androidx.compose.koinViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun HistoryScreen(viewModel: HistoryViewModel = koinViewModel(), NavController: NavHostController ) {
    val state by viewModel.historyUiState.collectAsStateWithLifecycle()



    Scaffold() { PaddingValues ->
        LazyColumn(modifier = Modifier.padding(PaddingValues)) {
            items(items = state.historyList) { item ->
                HistoryItem(
                    item,
                    onDelete = {
                        viewModel.onEvent(HistoryEvent.deleteHistory(item))
                    },
                    onStateUpdate = {
                        //URL encoded the expression to  handel slashes DO NOT TOUCH IT !!!
                        val encodedExpression = URLEncoder.encode(item.expression ,
                             StandardCharsets.UTF_8)

                        // passed that same shit from above
                        NavController.navigate(Screen.Calculator_Screen.CreateRoute(encodedExpression))
                    },
                )
            }

        }

    }


}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showSystemUi = true)
@Composable
private fun Pris() {

    HistoryScreen(NavController = rememberNavController() )
}


