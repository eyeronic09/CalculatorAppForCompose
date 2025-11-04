package com.example.calculator.Core_NavScreen

sealed class Screen(
    val route : String
){
    // Recevier
    object Calculator_Screen: Screen(route = "CalculatorScreen/{expression}"){
        fun CreateRoute(expression : String) = "CalculatorScreen/$expression"
    }
    //sender
    object History_Screen : Screen(route = "HistoryScreen")
}