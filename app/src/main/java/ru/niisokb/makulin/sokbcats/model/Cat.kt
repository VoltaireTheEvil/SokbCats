package ru.niisokb.makulin.sokbcats.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val id: String,
    val imageUrl: String,
) : Parcelable
