package com.medicalorganizer.cats.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "cats")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val breed: String = "",
    val dateOfBirth: Date? = null,
    val photoUri: String? = null,
    val notes: String = "",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

@Entity(tableName = "medical_files")
data class MedicalFile(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val catId: Long,
    val fileName: String,
    val fileUri: String,
    val fileType: String, // "DOCUMENT", "IMAGE", "PRESCRIPTION"
    val category: String, // "VACCINATION", "SURGERY", "CHECKUP", "OTHER"
    val description: String = "",
    val visitDate: Date? = null,
    val veterinarian: String = "",
    val createdAt: Date = Date()
)
