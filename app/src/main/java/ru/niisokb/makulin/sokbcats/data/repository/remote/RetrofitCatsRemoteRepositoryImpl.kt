package ru.niisokb.makulin.sokbcats.data.repository.remote

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

class RetrofitCatsRemoteRepositoryImpl @Inject constructor(
    private val apiService: CatsApiService,
    private val dispatchersProvider: DispatchersProvider
) : CatsRemoteRepository {

    override fun getPagedCats(): Flow<PagingData<Cat>> {

        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_LIMIT,
                enablePlaceholders = false,
                initialLoadSize = DEFAULT_LIMIT
            ),
            pagingSourceFactory = { CatsPagingSource(::getCats) }
        ).flow
    }

    private suspend fun getCats(): List<Cat> =
        withContext(dispatchersProvider.io()) {
            val cats = apiService.getCats()
            return@withContext cats.map { it.toCat() }
        }
}