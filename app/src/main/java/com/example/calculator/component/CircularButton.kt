package com.example.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun CircularButton(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(color = Color.DarkGray)
            .clickable(onClick = onClick)

    ) {
        Text(text = symbol,
            fontSize = 30.sp,
            modifier = Modifier)
    }
}


@Preview(showSystemUi = true)
@Composable
fun CircularButtonPreview() {
    CircularButton(onClick = { }, symbol = "X")
}