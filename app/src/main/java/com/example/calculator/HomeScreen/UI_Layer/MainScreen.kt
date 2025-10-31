package com.example.calculator.HomeScreen.UI_Layer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.calculator.Core_NavScreen.Screen
import com.example.calculator.HomeScreen.domain.CalculatorEvent
import com.example.calculator.HomeScreen.component.ButtonsGrid
import com.example.calculator.HomeScreen.component.DisplayResult
import com.example.calculator.HomeScreen.domain.CalculatorState
import com.example.calculator.HomeScreen.domain.NumberViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    viewModel: NumberViewModel = koinViewModel(),
    navController: NavHostController
) {

    val state: CalculatorState by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent

    Scaffold (
        contentWindowInsets = WindowInsets(),
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text("Calculator")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,

                ),
                actions = {
                    IconButton(
                        onClick = {navController.navigate(Screen.History_Screen.route)}
                    ) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                    }
                }
            )
        }
    ){ innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
            .windowInsetsPadding(WindowInsets.safeDrawing),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            DisplayResult(state)

            ButtonsGrid(
                onNumberClick = { onEvent(CalculatorEvent.Number(number = it)) },
                onOperationClick = { onEvent(CalculatorEvent.Operation(operation = it)) },
                onEqualTo = { onEvent(CalculatorEvent.Calculate) },
                onClear = { onEvent(CalculatorEvent.Delete) },
                onDropLast = {onEvent(CalculatorEvent.droplast)},
            )

        }
    }



}
