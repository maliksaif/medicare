package com.example.medicare.domain.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.medicare.domain.models.Medicine

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines WHERE id = :id")
    suspend fun getMedicineById(id: String): Medicine

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(medicines: List<Medicine>)
}