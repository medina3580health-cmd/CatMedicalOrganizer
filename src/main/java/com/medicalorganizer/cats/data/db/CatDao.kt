package com.medicalorganizer.cats.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.medicalorganizer.cats.data.model.Cat
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {
    @Insert
    suspend fun insertCat(cat: Cat): Long

    @Update
    suspend fun updateCat(cat: Cat)

    @Delete
    suspend fun deleteCat(cat: Cat)

    @Query("SELECT * FROM cats ORDER BY name ASC")
    fun getAllCats(): Flow<List<Cat>>

    @Query("SELECT * FROM cats WHERE id = :catId")
    fun getCatById(catId: Long): Flow<Cat>

    @Query("SELECT * FROM cats WHERE name LIKE '%' || :query || '%'")
    fun searchCats(query: String): Flow<List<Cat>>
}
