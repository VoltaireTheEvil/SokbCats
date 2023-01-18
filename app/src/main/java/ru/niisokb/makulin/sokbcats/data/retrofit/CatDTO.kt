package ru.niisokb.makulin.sokbcats.data.retrofit

import com.google.gson.annotations.SerializedName

data class CatDTO(
    val id: String,
    @SerializedName(value = "url")
    val imageUrl: String
)
