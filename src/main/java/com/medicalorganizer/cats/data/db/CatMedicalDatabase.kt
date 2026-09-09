package com.medicalorganizer.cats.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.medicalorganizer.cats.data.model.Cat
import com.medicalorganizer.cats.data.model.MedicalFile

@Database(entities = [Cat::class, MedicalFile::class], version = 1)
@TypeConverters(Converters::class)
abstract class CatMedicalDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
    abstract fun medicalFileDao(): MedicalFileDao
}
