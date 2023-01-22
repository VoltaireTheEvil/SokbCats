package ru.niisokb.makulin.sokbcats.data.room

import androidx.room.*

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCat(cat: CatEntity)

    @Delete
    suspend fun deleteCat(cat: CatEntity)

    @Query("SELECT * FROM cats ORDER BY updated_at DESC")
    suspend fun getCatsList(): List<CatEntity>
}