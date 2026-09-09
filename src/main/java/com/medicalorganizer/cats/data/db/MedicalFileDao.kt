package com.medicalorganizer.cats.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.medicalorganizer.cats.data.model.MedicalFile
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalFileDao {
    @Insert
    suspend fun insertFile(medicalFile: MedicalFile): Long

    @Update
    suspend fun updateFile(medicalFile: MedicalFile)

    @Delete
    suspend fun deleteFile(medicalFile: MedicalFile)

    @Query("SELECT * FROM medical_files WHERE catId = :catId ORDER BY visitDate DESC, createdAt DESC")
    fun getFilesByCat(catId: Long): Flow<List<MedicalFile>>

    @Query("SELECT * FROM medical_files WHERE catId = :catId AND category = :category")
    fun getFilesByCategory(catId: Long, category: String): Flow<List<MedicalFile>>

    @Query("SELECT * FROM medical_files WHERE id = :fileId")
    fun getFileById(fileId: Long): Flow<MedicalFile>

    @Query("SELECT * FROM medical_files WHERE fileName LIKE '%' || :query || '%'")
    fun searchFiles(query: String): Flow<List<MedicalFile>>

    @Query("DELETE FROM medical_files WHERE catId = :catId")
    suspend fun deleteFilesByCat(catId: Long)
}
