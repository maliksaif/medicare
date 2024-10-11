package com.example.medicare.data

import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.models.MedicineResponse
import retrofit2.http.GET

interface MedicineApiService {
    @GET("a1325c93-b2c6-489e-8d94-c159024b2463")
    suspend fun getMedicines(): MedicineResponse
}