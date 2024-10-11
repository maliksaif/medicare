package com.example.medicare.data

import com.example.medicare.domain.models.Medicine
import javax.inject.Inject

interface MedicineRepository {
    suspend fun getMedicines(): List<Medicine>
}