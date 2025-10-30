package com.example.calculator.HomeScreen.component

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.HomeScreen.domain.CalculatorOperation
import com.example.calculator.HomeScreen.domain.CalculatorState
import com.example.calculator.ui.theme.CalculatorTheme
@Composable
fun DisplayResult(state: CalculatorState) {
   CalculatorTheme {
       Surface(
           modifier = Modifier.fillMaxWidth().systemBarsPadding(),
           color = MaterialTheme.colorScheme.background
       ) {
           Column (modifier = Modifier.fillMaxWidth(1f)){
               Text(
                   modifier = Modifier.fillMaxWidth(),
                   text = state.expression,
                   style = MaterialTheme.typography.displayMedium,
                   color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                   textAlign = TextAlign.End
               )
               Text(modifier = Modifier.fillMaxWidth(),
                   text = state.result,
                   textAlign = TextAlign.End,
                   style = MaterialTheme.typography.labelMedium,
               )
           }
       }
   }
}


@Preview(
    name = "Light Mode",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DisplayResultPreview() {
    val previewState = CalculatorState(
        number1 = "34",
        number2 = "32",
        result = "23",
        expression = "2/43+2*32-32",
        operation = CalculatorOperation.Add
    )
    CalculatorTheme {
        DisplayResult(previewState)
    }
}
