package ru.niisokb.makulin.sokbcats.data.room

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    private val df = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    @TypeConverter
    fun toDate(date: String): Date {
        return df.parse(date)
    }

    @TypeConverter
    fun toDateString(date: Date): String {
        return df.format(date)
    }
}