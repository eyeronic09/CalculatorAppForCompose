package com.example.calculator.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Nothing_Family

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
        Text(text = symbol, fontSize = 30.sp ,
            style = MaterialTheme.typography.displayLarge,
             )
    }
}


@Preview(showBackground = true)
@Composable
fun CircularButtonPreview() {
    CircularButton(onClick = { }, symbol = "X")
}
