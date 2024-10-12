package com.example.medicare.data

import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.models.MedicineResponse
import retrofit2.http.GET

interface MedicineApiService {
    @GET("aa2c93a1-046e-4d16-b7a4-a0979cfdc1dd")
    suspend fun getMedicines(): MedicineResponse
}