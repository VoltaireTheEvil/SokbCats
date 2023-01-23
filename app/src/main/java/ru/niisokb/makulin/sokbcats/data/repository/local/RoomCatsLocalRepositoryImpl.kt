package ru.niisokb.makulin.sokbcats.data.repository.local

import kotlinx.coroutines.withContext
import ru.niisokb.makulin.sokbcats.data.room.CatDao
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.data.toEntity
import ru.niisokb.makulin.sokbcats.utils.dispatchers.DispatchersProvider
import javax.inject.Inject

class RoomCatsLocalRepositoryImpl @Inject constructor(
    private val catDao: CatDao,
    private val dispatchersProvider: DispatchersProvider
) : CatsLocalRepository {

    override suspend fun addToFavorite(cat: Cat) {
        withContext(dispatchersProvider.io()) {
            catDao.insertCat(cat.toEntity())
        }
    }

    override suspend fun getAllFavorites(): List<Cat> {
        return withContext(dispatchersProvider.io()) {
            catDao.getCatsList()
                .map { it.toCat() }
        }
    }


    override suspend fun delete(cat: Cat) {
        withContext(dispatchersProvider.io()) {
            catDao.deleteCat(cat.toEntity())
        }
    }

}