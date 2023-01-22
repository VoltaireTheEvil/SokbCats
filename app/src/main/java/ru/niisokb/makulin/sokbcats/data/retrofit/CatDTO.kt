package ru.niisokb.makulin.sokbcats.data.retrofit

import com.google.gson.annotations.SerializedName
import ru.niisokb.makulin.sokbcats.model.Cat

data class CatDTO(
    val id: String,
    @SerializedName(value = "url")
    val imageUrl: String
) {
    fun toCat(): Cat =
        Cat(
            id = id,
            imageUrl = imageUrl
        )
}
