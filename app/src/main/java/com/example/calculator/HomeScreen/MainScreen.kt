package com.example.calculator.HomeScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
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
import com.example.calculator.domain.NumberViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorView(
    viewModel: NumberViewModel,

) {
    val state: CalculatorState by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){
        Text(
            text = buildString {
                append(state.number1)
                append(
                    when (state.operation) {
                        CalculatorOperation.Add -> " + "
                        CalculatorOperation.Divide -> " ÷ "
                        CalculatorOperation.Multiply -> " × "
                        CalculatorOperation.Subtract -> " - "
                        null -> ""
                    }
                )
                append(state.number2.ifBlank { "" } )


            }

        )
        Text(text ="${state.result}")




        ButtonsGrid(onNumberClick = { onEvent(CalculatorEvent.Number(number = it))},
            onOperationClick = { onEvent(CalculatorEvent.Operation(it )) },
            onEqualTo = { onEvent(CalculatorEvent.Calculate) },
            onClear = {onEvent(CalculatorEvent.Delete)},
        )

    }


}

@Preview(showSystemUi = true)
@Composable
fun previs() {
    CalculatorView(viewModel = NumberViewModel())
}