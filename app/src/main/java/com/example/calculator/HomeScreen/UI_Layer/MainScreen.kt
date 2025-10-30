package com.example.calculator.HomeScreen.UI_Layer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

) {
    val state: CalculatorState by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 16.dp),
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
