package ru.niisokb.makulin.sokbcats.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.niisokb.makulin.sokbcats.model.Cat
import java.util.*

@Entity(tableName = "cats")
@TypeConverters(DateConverter::class)
data class CatEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
    @ColumnInfo(name = "updated_at")
    val updatedAt: Date
) {
    fun toCat(): Cat =
        Cat(
            id = id,
            imageUrl = imageUrl
        )
}