package ru.niisokb.makulin.sokbcats.utils.data

import ru.niisokb.makulin.sokbcats.data.room.CatEntity
import ru.niisokb.makulin.sokbcats.model.Cat
import java.text.SimpleDateFormat
import java.util.*

fun currentDate(): Date {
    val df = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val date = df.format(Date(System.currentTimeMillis()))
    return df.parse(date)
}


fun Cat.toEntity(): CatEntity {
    return CatEntity(
        id = id,
        imageUrl = imageUrl,
        createdAt = currentDate(),
        updatedAt = currentDate()
    )
}