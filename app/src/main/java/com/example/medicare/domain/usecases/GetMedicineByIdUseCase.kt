package com.example.medicare.domain.usecases

import com.example.medicare.domain.room.MedicineDao
import javax.inject.Inject

class GetMedicineByIdUseCase @Inject constructor(private val medicineDao: MedicineDao) {
    suspend operator fun invoke(medicineId: String) = medicineDao.getMedicineById(medicineId)
}