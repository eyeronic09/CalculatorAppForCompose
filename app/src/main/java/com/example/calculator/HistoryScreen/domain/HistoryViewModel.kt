package com.example.calculator.HistoryScreen.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.calculator.HomeScreen.Room.Repository.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel (private val repository: HistoryRepository) : ViewModel() {
    private val _historyUiState = MutableStateFlow(HistoryState())
    val historyUiState: StateFlow<HistoryState> = _historyUiState.asStateFlow()

    init {
        loadHistory()
    }

    fun onEvent(event: HistoryEvent) {
        when (event) {

            is HistoryEvent.deleteHistory -> TODO()
        }


    }
    fun loadHistory() {
        viewModelScope.launch {
            try {
               repository.getAllHistory().collect { value ->
                    _historyUiState.update { historyState ->
                        historyState.copy(historyList = value)
                    }
                }
            } catch (e: Exception) {
                _historyUiState.update { it.copy(error = e.message) }
            }
        }
    }

}