package com.example.medicare.ui.screens.dashboard.home

import com.example.medicare.domain.models.Medicine

data class HomeState(
    var isLoading : Boolean = false,
    var greetings : String = "",
    var username : String = "",
    var greetingsMessage : String = "",
    var medicineList : List<Medicine> = emptyList()
)


sealed class HomeEvent {

    data class OnMedicineSelected(val medicine : Medicine) : HomeEvent()

}