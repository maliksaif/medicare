package com.example.medicare.ui.screens.dashboard.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.usecases.GetGreetingsMessageUseCase
import com.example.medicare.ui.screens.dashboard.home.HomeEvent.OnMedicineSelected
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val getGreetingsMessageUseCase: GetGreetingsMessageUseCase
) : ViewModel() {

    var homeUiState by mutableStateOf(HomeState())

    init {

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