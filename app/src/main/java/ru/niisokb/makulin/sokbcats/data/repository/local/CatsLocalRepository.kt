package ru.niisokb.makulin.sokbcats.data.repository.local

import ru.niisokb.makulin.sokbcats.model.Cat

interface CatsLocalRepository {

    suspend fun addToFavorite(cat: Cat)

    suspend fun getAllFavorites(): List<Cat>

    suspend fun delete(cat: Cat)
}