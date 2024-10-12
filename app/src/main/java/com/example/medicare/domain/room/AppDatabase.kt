package com.example.medicare.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.medicare.domain.models.Medicine

@Database(entities = [Medicine::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
}