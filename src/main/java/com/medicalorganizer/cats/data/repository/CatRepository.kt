package com.medicalorganizer.cats.data.repository

import com.medicalorganizer.cats.data.db.CatDao
import com.medicalorganizer.cats.data.db.MedicalFileDao
import com.medicalorganizer.cats.data.model.Cat
import com.medicalorganizer.cats.data.model.MedicalFile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatRepository @Inject constructor(
    private val catDao: CatDao,
    private val medicalFileDao: MedicalFileDao
) {
    // Cat operations
    suspend fun addCat(cat: Cat): Long = catDao.insertCat(cat)

    suspend fun updateCat(cat: Cat) = catDao.updateCat(cat)

    suspend fun deleteCat(cat: Cat) = catDao.deleteCat(cat)

    fun getAllCats(): Flow<List<Cat>> = catDao.getAllCats()

    fun getCatById(catId: Long): Flow<Cat> = catDao.getCatById(catId)

    fun searchCats(query: String): Flow<List<Cat>> = catDao.searchCats(query)

    // Medical file operations
    suspend fun addMedicalFile(medicalFile: MedicalFile): Long =
        medicalFileDao.insertFile(medicalFile)

    suspend fun updateMedicalFile(medicalFile: MedicalFile) =
        medicalFileDao.updateFile(medicalFile)

    suspend fun deleteMedicalFile(medicalFile: MedicalFile) =
        medicalFileDao.deleteFile(medicalFile)

    fun getMedicalFilesByCat(catId: Long): Flow<List<MedicalFile>> =
        medicalFileDao.getFilesByCat(catId)

    fun getMedicalFilesByCategory(catId: Long, category: String): Flow<List<MedicalFile>> =
        medicalFileDao.getFilesByCategory(catId, category)

    fun searchMedicalFiles(query: String): Flow<List<MedicalFile>> =
        medicalFileDao.searchFiles(query)

    suspend fun deleteFilesByCat(catId: Long) = medicalFileDao.deleteFilesByCat(catId)
}
