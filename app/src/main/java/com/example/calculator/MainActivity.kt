package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calculator.component.ButtonsGrid
import com.example.calculator.domain.NumberViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel = NumberViewModel()
            CalculatorScreen(viewModel)

        }
    }

    @Composable
    fun CalculatorScreen(viewModel: NumberViewModel) {
        val state by viewModel::state
        val onEvent = viewModel::onEvent
        Scaffold() { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${state}")
                ButtonsGrid(
                    onNumberClick = {it -> onEvent(CalculatorEvent.Number(number = it)) },
                    onOperationClick = { operation -> onEvent(CalculatorEvent.Operation(operation)) },
                    onEqualTo = {onEvent(CalculatorEvent.Calculate)},
                )
            }
            Log.d("state",state.toString())

        }
    }
}

