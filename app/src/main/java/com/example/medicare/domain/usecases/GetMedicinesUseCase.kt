package com.example.medicare.domain.usecases

import com.example.medicare.data.MedicineApiService
import com.example.medicare.data.MedicineRepository
import com.example.medicare.domain.models.Medicine
import javax.inject.Inject

class GetMedicinesUseCase @Inject constructor(
    private val apiService: MedicineApiService
) : MedicineRepository {
    override suspend fun getMedicines(): List<Medicine> {
        return apiService.getMedicines().medicines
    }
}