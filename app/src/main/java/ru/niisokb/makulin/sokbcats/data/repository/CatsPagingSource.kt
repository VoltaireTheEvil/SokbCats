package ru.niisokb.makulin.sokbcats.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.niisokb.makulin.sokbcats.model.Cat

class CatsPagingSource(
    private val catsLoader: suspend () -> List<Cat>
) : PagingSource<Int, Cat>() {

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val paramsIndex = params.key ?: 0
        return try {
            val cats = catsLoader.invoke()
            return LoadResult.Page(
                data = cats,
                prevKey = null,
                nextKey = paramsIndex + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(
                throwable = e
            )
        }
    }
}

