package com.example.medicare.domain.models


data class MedicineResponse(
    val medicines: List<Medicine>
)

data class Medicine(
    val id: String,
    val name: String,
    val dose: String,
    val strength: String
)
