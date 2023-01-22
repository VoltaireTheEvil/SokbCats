package ru.niisokb.makulin.sokbcats.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [CatEntity::class]
)
abstract class CatDatabase : RoomDatabase() {

    abstract fun getCatDao(): CatDao
}