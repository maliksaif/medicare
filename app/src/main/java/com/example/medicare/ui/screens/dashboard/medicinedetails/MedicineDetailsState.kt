package com.example.medicare.ui.screens.dashboard.medicinedetails

import com.example.medicare.domain.models.Medicine


data class MedicineDetailsState(
    val selectedMedicineId: String = "",
    val medicine: Medicine? = null
)