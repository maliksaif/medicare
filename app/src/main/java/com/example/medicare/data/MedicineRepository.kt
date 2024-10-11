package com.example.medicare.data

import com.example.medicare.domain.models.Medicine

interface MedicineRepository {
    suspend fun getMedicines(): List<Medicine>
}