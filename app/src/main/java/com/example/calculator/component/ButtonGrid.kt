package com.example.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.CalculatorEvent
import com.example.calculator.CalculatorOperation

@Composable
fun ButtonsGrid(
    onNumberClick: (String) -> Unit,
    onOperationClick: (CalculatorOperation) -> Unit,
    onEqualTo: (CalculatorEvent.Calculate) -> Unit,
    onClear: (CalculatorEvent.Delete) -> Unit
) {
    val buttons = listOf(
        "7", "8", "9", "/",
        "4", "5", "6", "X",
        "1", "2", "3", "-", "+",
        "0", ".", "=", "CE"
    )



    
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter

    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
              columns = GridCells.Fixed(count = 4),
        ) {
            items(buttons) { button ->
                when (button) {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                        CircularButton(
                            onClick = {
                                onNumberClick(button)
                                      },
                            symbol = button,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    "+" -> CircularButton(
                        onClick = { onOperationClick(CalculatorOperation.Add) },
                        symbol = "+",
                        modifier = Modifier.padding(8.dp)
                     )

                    "X" -> CircularButton(
                        onClick = { onOperationClick(CalculatorOperation.Multiply) },
                        symbol = "X",
                        modifier = Modifier.padding(8.dp)
                             )

                    "-" -> CircularButton(
                        onClick = { onOperationClick(CalculatorOperation.Subtract) },
                        symbol = "-",
                        modifier = Modifier.padding(8.dp)
                         )

                    "/" -> CircularButton(
                        onClick = { onOperationClick(CalculatorOperation.Divide) },
                        symbol = "/",
                        modifier = Modifier.padding(8.dp)
                    )

                    "=" -> CircularButton(
                        onClick = { onEqualTo.invoke(CalculatorEvent.Calculate) },
                        symbol = "=",
                        modifier = Modifier.padding(8.dp)
                       )

                    "CE" -> CircularButton(
                        onClick = { onClear(CalculatorEvent.Delete) },
                        symbol = "CE",
                        modifier = Modifier.padding(8.dp)
                      )

                    "." -> CircularButton(
                        onClick = { },
                        symbol = ".",
                        modifier = Modifier.padding(8.dp)
                        )


                }
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
private fun pea() {
    ButtonsGrid(
        onNumberClick = {},
        onOperationClick = {},
        onEqualTo = {},
        onClear = {},
    )

}
