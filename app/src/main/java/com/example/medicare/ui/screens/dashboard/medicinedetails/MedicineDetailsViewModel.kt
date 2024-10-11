package com.example.medicare.ui.screens.dashboard.medicinedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.medicare.domain.models.Medicine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MedicineDetailsViewModel @Inject constructor() : ViewModel() {

    var medicineDetailsState by mutableStateOf(MedicineDetailsState())

    // When using RooM ID to Query the data
    fun setMedicineId(medicineId: String) {
        medicineDetailsState = medicineDetailsState.copy(selectedMedicineId = medicineId)
    }

    fun setMedicine(medicine: Medicine) {
        medicineDetailsState = medicineDetailsState.copy(medicine = medicine)
    }

}