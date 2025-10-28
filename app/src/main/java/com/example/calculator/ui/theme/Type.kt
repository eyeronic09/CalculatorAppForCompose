package com.example.calculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.calculator.R

// Define your font family
  val Nothing_Family = FontFamily(
    Font(resId = R.font.custom, weight = FontWeight.Normal)
)
// Material 3 Typography with custom font
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Nothing_Family,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Nothing_Family,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    // Add other text styles as needed
    bodyLarge = TextStyle(
        fontFamily = Nothing_Family,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)