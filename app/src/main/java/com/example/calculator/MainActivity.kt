package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.calculator.domain.NumberViewModel
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {

                    val viewModel  = NumberViewModel()
                    Calculator(viewModel)

            }
        }
    }
}

@Composable
fun Calculator(viewModel: NumberViewModel ) {
    val state by viewModel::state
    val onEvent = viewModel::onEvent
    Scaffold { innerPadding ->

        Column {
            Text(text = "$state",modifier = Modifier.padding(innerPadding))

            Buttons(
                onClick = {onEvent(CalculatorEvent.Number(1.toString()))},
                sysmbol = "1",
                modifier = Modifier
            )
            Buttons(

            )
        }


    }


}

@Composable
fun Buttons(onClick:() -> Unit,  sysmbol : String , modifier: Modifier){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.clip(CircleShape).clickable(onClick = onClick)){
        Text(text = sysmbol, fontSize = 36.sp, modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CalculatorTheme {
        val  vm = NumberViewModel()
        Calculator(vm)
    }
}
@Preview(showBackground = true)
@Composable
fun prev(){
    Buttons({},"2", modifier = Modifier )
}