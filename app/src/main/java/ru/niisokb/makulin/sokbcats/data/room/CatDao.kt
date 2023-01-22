package ru.niisokb.makulin.sokbcats.data.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCat(cat: CatEntity): String

    @Delete
    suspend fun deleteCat(cat: CatEntity): String

    @Query("SELECT * FROM cats ORDER BY updated_at DESC")
    suspend fun getCatsList(): List<CatEntity>
}