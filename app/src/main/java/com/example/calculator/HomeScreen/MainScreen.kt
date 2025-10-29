package com.example.calculator.HomeScreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation
import com.example.calculator.component.ButtonsGrid
import com.example.calculator.component.DisplayResult
import com.example.calculator.domain.NumberViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    viewModel: NumberViewModel,

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
            onOperationClick = { onEvent(CalculatorEvent.Operation(it)) },
            onEqualTo = { onEvent(CalculatorEvent.Calculate) },
            onClear = { onEvent(CalculatorEvent.Delete) },
            onDropLast = {onEvent(CalculatorEvent.droplast)},
        )

    }


}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun previs() {
    CalculatorView(viewModel = NumberViewModel())
}