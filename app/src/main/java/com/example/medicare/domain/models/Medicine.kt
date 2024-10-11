package com.example.medicare.domain.models


/*
*
* -----------------------
* Provided response in sample
* has been reduced to keep it simple
* but for the reference i have also provided how we
* can parse that original response.
* -----------------------
* */
data class MedicineResponse(
    val medicines: List<Medicine>
)

data class Medicine(
    val id: String,
    val name: String,
    val dose: String,
    val strength: String,
    val description : String
)
