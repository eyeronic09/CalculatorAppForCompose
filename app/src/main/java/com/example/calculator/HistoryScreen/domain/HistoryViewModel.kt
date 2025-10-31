package com.example.calculator.HistoryScreen.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.HomeScreen.Room.Repository.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel (private val repository: HistoryRepository) : ViewModel(){
    private val _historyState = MutableStateFlow(HistoryState())
    val historyState : StateFlow<HistoryState> = _historyState.asStateFlow()

    init {
        fetchAllHistory()
    }

    fun onEvent(event: HistoryEvent){
        when(event) {
            is HistoryEvent.currentHistoryUpdateToState -> TODO()
            is HistoryEvent.deleteHistory -> TODO()
        }


    }
    private fun fetchAllHistory() {
        viewModelScope.launch {
            try {
                _historyState.update { historyState ->
                    historyState.copy(
                        isLoading = true,
                        historyList = historyState.historyList
                    )
                }
            }catch (e: Exception){
                _historyState.value.copy(error = e.toString())
            }
        }
    }
}