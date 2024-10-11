package com.example.medicare.ui.screens.dashboard.medicinedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor() : ViewModel() {

    var medicineDetailsState by mutableStateOf(MedicineDetailsState())

    fun setMedicineId(medicineId: String) {
        medicineDetailsState = medicineDetailsState.copy(selectedMedicineId = medicineId)
    }


}