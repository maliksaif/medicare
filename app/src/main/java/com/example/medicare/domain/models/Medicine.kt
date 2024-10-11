package com.example.medicare.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


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

@Parcelize
data class Medicine(
    val id: String,
    val name: String,
    val dose: String,
    val strength: String,
    val description : String
) : Parcelable
