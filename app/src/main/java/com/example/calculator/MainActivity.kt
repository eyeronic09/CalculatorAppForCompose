package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.example.calculator.HomeScreen.UI_Layer.CalculatorView
import com.example.calculator.ui.theme.CalculatorTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold () { innerPadding ->
                    CalculatorView(
                        paddingValues = innerPadding
                    )
                }
            }
        }
    }
}