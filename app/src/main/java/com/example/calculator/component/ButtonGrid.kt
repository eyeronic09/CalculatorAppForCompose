package com.example.calculator.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.Buttons
import com.example.calculator.Calculator
import com.example.calculator.CalculatorOperation

@Composable
fun ButtonsGrid(
    modifier: Modifier = Modifier,
    onNumberClick :(String) -> Unit,
    onOperationClick:(CalculatorOperation)  -> Unit
) {
    val buttons = listOf(
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "⌫"
    )


    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(4),
    ) {

        items(buttons) { it ->
            when (it) {
                "+" -> Buttons(
                    onClick = { onOperationClick(CalculatorOperation.Add) },
                    sysmbol = "+",
                    modifier = Modifier
                )

                "*" -> Buttons(
                    onClick = { onOperationClick(CalculatorOperation.Multiply) },
                    sysmbol = "*",
                    modifier = Modifier
                )

                "-" -> Buttons(
                    onClick = { onOperationClick(CalculatorOperation.Subtract) },
                    sysmbol = "-",
                    modifier = Modifier
                )

                "/" -> Buttons(
                    onClick = { onOperationClick(CalculatorOperation.Divide) },
                    sysmbol = "/",
                    modifier = Modifier
                )

                "0" -> Buttons(
                    onClick = { onNumberClick("0") },
                    sysmbol = "0",
                    modifier = Modifier
                )

                "." -> Buttons(
                    onClick = { onNumberClick(".") },
                    sysmbol = ".",
                    modifier = Modifier
                )

                "=" -> Buttons(
                    onClick = { onNumberClick("=") },
                    sysmbol = "=",
                    modifier = Modifier
                )

                "⌫" -> Buttons(
                    onClick = { onNumberClick("⌫") },
                    sysmbol = "⌫",
                    modifier = Modifier
                )

                else -> Buttons(
                    onClick = { onNumberClick(it) },
                    sysmbol = it,
                    modifier = Modifier
                )
            }
        }
    }

}
@Preview
@Composable
private fun ors() {
    ButtonsGrid(
        modifier = Modifier,
        onNumberClick = {},
        onOperationClick = {}
    )
}