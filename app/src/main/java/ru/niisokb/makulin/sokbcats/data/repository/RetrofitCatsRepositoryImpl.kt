package ru.niisokb.makulin.sokbcats.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ru.niisokb.makulin.sokbcats.data.retrofit.CatsApiService
import ru.niisokb.makulin.sokbcats.data.retrofit.DEFAULT_LIMIT
import ru.niisokb.makulin.sokbcats.model.Cat
import ru.niisokb.makulin.sokbcats.utils.dispatchers.DispatchersProvider
import javax.inject.Inject

class RetrofitCatsRepositoryImpl @Inject constructor(
    private val apiService: CatsApiService,
    private val dispatchersProvider: DispatchersProvider
) : CatsRepository {

    override fun getPagedCats(): Flow<PagingData<Cat>> =
        Pager(
            config = PagingConfig(
                pageSize = DEFAULT_LIMIT,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TODO()}
        ).flow

    private suspend fun getCats(): List<Cat> =
        withContext(dispatchersProvider.io()) {
            val cats = apiService.getCats()
            return@withContext cats.map { it.toCat() }
        }
}