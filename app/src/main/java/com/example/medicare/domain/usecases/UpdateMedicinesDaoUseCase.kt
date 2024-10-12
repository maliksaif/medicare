package com.example.medicare.domain.usecases

import com.example.medicare.domain.models.Medicine
import com.example.medicare.domain.room.MedicineDao
import javax.inject.Inject

class UpdateMedicinesDaoUseCase @Inject constructor(private val medicineDao: MedicineDao) {

    suspend operator fun invoke(medicines: List<Medicine>) {
        medicineDao.insertAll(medicines)
    }

}