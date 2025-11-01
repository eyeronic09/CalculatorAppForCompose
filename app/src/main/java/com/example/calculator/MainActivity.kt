package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.calculator.Core_NavScreen.Screen
import com.example.calculator.HistoryScreen.Ui_Layer.HistoryScreen
import com.example.calculator.HomeScreen.UI_Layer.CalculatorView
import com.example.calculator.ui.theme.CalculatorTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge(
          statusBarStyle = SystemBarStyle.auto(
              lightScrim = Color.TRANSPARENT,
              darkScrim = Color.TRANSPARENT
          )
       )
        setContent {
            CalculatorTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Calculator_Screen.route
    ) {
        composable(Screen.Calculator_Screen.route,
           ){
            CalculatorView(
                navController = navController
            )
        }
        composable (
            Screen.History_Screen.route,
            arguments = listOf(navArgument("expression"){type = NavType.StringType})
            ) { backStackEntry ->
            val exp = backStackEntry.arguments?.getString("expression") ?: ""
            HistoryScreen(
               NavController = navController,
                initial_Expression = exp
            )
        }
    }

}