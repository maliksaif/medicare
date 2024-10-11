package com.example.medicare.ui.screens.dashboard.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicare.data.MedicineRepository
import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.usecases.GetGreetingsMessageUseCase
import com.example.medicare.domain.usecases.GetMedicinesUseCase
import com.example.medicare.ui.screens.dashboard.home.HomeEvent.OnMedicineSelected
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val getGreetingsMessageUseCase: GetGreetingsMessageUseCase,
    private val getMedicineUseCase: GetMedicinesUseCase
) : ViewModel() {

    var homeUiState by mutableStateOf(HomeState())

    init {

        fetchMedicines()
        
    }

    private fun fetchMedicines() {
        viewModelScope.launch {
            val medicines = getMedicineUseCase.getMedicines()
            homeUiState = homeUiState.copy(medicineList = medicines)
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is OnMedicineSelected -> handleOnMedicineSelected(event.medicine)
        }
    }


    private fun handleOnMedicineSelected(medicine: Medicine) {
        // Navigate to medicine details screen

    }

    fun setUsername(username: String) {
        val greetings = getGreetingsMessageUseCase()
        homeUiState = homeUiState.copy(
            greetings = greetings,
            username = username,
            greetingsMessage = "${getGreetingsMessageUseCase()}, ${username}!"
        )
    }

}