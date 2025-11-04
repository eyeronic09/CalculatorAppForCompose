package com.example.calculator.HomeScreen.domain

data class CalculatorState(
    // result self explanatory
    val result: String ="",
    //this is current expression hold current state when user buttons prees //
    val expression: String = "" ,
    //this is coming from event
    //  like _+/*
    val operation: CalculatorOperation? = null
)