package com.example.calculator.component

import android.R
import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation

@Composable
fun ButtonsGrid(
    onNumberClick: (String) -> Unit,
    onOperationClick: (CalculatorOperation) -> Unit,
    onEqualTo:(CalculatorEvent.Calculate) -> Unit
) {
    val buttons = listOf(
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-","+",
        "0", ".", "=", "⌫"
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
    ) {
        items(buttons) { button ->
            when (button) {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    CircularButton(
                        onClick = { onNumberClick(button)
                                  Log.d("NumButtom" , button)},
                        symbol = button,
                        modifier = Modifier
                    )
                }
                "+" -> CircularButton(
                    onClick = { onOperationClick(CalculatorOperation.Add) },
                    symbol = "+",
                    modifier = Modifier
                )
                "*" -> CircularButton(
                    onClick = { onOperationClick(CalculatorOperation.Multiply) },
                    symbol = "*",
                    modifier = Modifier
                )
                "-" -> CircularButton(
                    onClick = { onOperationClick(CalculatorOperation.Subtract) },
                    symbol = "-",
                    modifier = Modifier
                )
                "/" -> CircularButton(
                    onClick = { onOperationClick(CalculatorOperation.Divide) },
                    symbol = "/",
                    modifier = Modifier
                )
                "=" -> CircularButton(
                    onClick = { onEqualTo(CalculatorEvent.Calculate)},
                    symbol = "=",
                    modifier = Modifier
                )
                "⌫" -> CircularButton(
                    onClick = { /* Handle backspace */ },
                    symbol = "⌫",
                    modifier = Modifier
                )
                "." -> CircularButton(
                    onClick = {  },
                    symbol = ".",
                    modifier = Modifier
                )


            }
        }
    }
}