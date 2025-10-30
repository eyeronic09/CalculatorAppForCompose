package com.example.calculator.HomeScreen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CircularButton(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier,

    ) {
    Button(
        modifier = Modifier.aspectRatio(1f), colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        shape = CircleShape,
        onClick = onClick,

    ) {
        Box {
            Text(text = symbol ,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CircularButtonPreview() {
    CircularButton(onClick = { }, symbol = "X")
}
