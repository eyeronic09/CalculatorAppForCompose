package com.example.calculator.HomeScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.HomeScreen.domain.CalculatorEvent
import com.example.calculator.HomeScreen.domain.CalculatorOperation

@Composable
fun RectangularButton(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.Red),
        shape = RoundedCornerShape(28.dp),
        onClick = onClick,
    ) {
        Box {
            Text(
                text = symbol,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1
            )
        }
    }
}
@Composable
fun ButtonsGrid(
    onNumberClick: (String) -> Unit,
    onOperationClick: (CalculatorOperation) -> Unit,
    onEqualTo: (CalculatorEvent.Calculate) -> Unit,
    onClear: (CalculatorEvent.Delete) -> Unit,
    onDropLast:(CalculatorEvent.Droplast) -> Unit
) {
    val buttons = listOf(
        "7", "8", "9", "/",
        "4", "5", "6", "X",
        "1", "2", "3", "-", "+",
        "0", ".", "=" ,
    )

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyVerticalGrid(
            modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            columns = GridCells.Fixed(count = 4),
        ) {
            items(buttons) { button ->
                when (button) {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                        CircularButton(
                            onClick = { onNumberClick(button) },
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

                    "." -> CircularButton(
                        onClick = {onNumberClick(button) },
                        symbol = ".",
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
            item(span = { GridItemSpan(2) }) {
                    RectangularButton(
                        onClick = { onClear(CalculatorEvent.Delete) },
                        symbol = "CE",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )


            }
            item(span = {GridItemSpan(2)}) {
                RectangularButton(
                    onClick = {onDropLast(CalculatorEvent.Droplast)},
                    symbol =  "droplast",
                    modifier = Modifier.padding(8.dp)
                )
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
        onDropLast = {}
    )
}
