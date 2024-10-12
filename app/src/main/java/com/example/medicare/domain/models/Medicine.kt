package com.example.medicare.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
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
@Entity(tableName = "medicines")
@Parcelize
data class Medicine(
    @PrimaryKey val id: String,
    val name: String,
    val dose: String,
    val strength: String,
    val description : String
) : Parcelable
