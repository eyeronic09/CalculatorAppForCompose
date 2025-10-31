package com.example.calculator.Core_NavScreen

sealed class Screen(
    val route : String
){
    object Calculator_Screen: Screen(route = "CalculatorScreen")
    object History_Screen : Screen(route = "HistoryScreen")
}