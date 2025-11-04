package com.example.calculator.HomeScreen.UI_Layer

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.calculator.Core_NavScreen.Screen
import com.example.calculator.HomeScreen.component.ButtonsGrid
import com.example.calculator.HomeScreen.component.DisplayResult
import com.example.calculator.HomeScreen.domain.CalculatorEvent
import com.example.calculator.HomeScreen.domain.CalculatorState
import com.example.calculator.HomeScreen.domain.NumberViewModel
import org.koin.androidx.compose.koinViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    viewModel: NumberViewModel = koinViewModel(),
    navController: NavHostController,
    expression : String
) {

    val state: CalculatorState by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent

    LaunchedEffect(expression) {
        if (expression.isNotBlank()) {
            val o = URLDecoder.decode(expression, StandardCharsets.UTF_8.toString())
            Log.d("decode", o)
            viewModel.onEvent(CalculatorEvent.SetExpression(o))

        }
    }

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
                        Icon(Icons.Filled.History, contentDescription = "Favorite")
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
            DisplayResult(state.copy(expression = state.expression)).also {
                Log.d("stateLog",state.toString())
            }
            ButtonsGrid(
                onNumberClick = { onEvent(CalculatorEvent.Number(number = it)) },
                onOperationClick = { onEvent(CalculatorEvent.Operation(operation = it)) },
                onEqualTo = { onEvent(CalculatorEvent.Calculate) },
                onClear = { onEvent(CalculatorEvent.Delete) },
                onDropLast = { onEvent(CalculatorEvent.Droplast) },
            )

        }
    }
}