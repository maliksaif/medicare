package com.example.medicare.data

import com.example.medicare.domain.models.Medicine
import retrofit2.http.GET

interface MedicineApiService {
    @GET("e3645e3a-16de-479b-a0d8-6170447e1daa")
    suspend fun getMedicines(): List<Medicine>
}