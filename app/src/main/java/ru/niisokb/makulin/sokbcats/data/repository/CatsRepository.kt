package ru.niisokb.makulin.sokbcats.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.niisokb.makulin.sokbcats.model.Cat

interface CatsRepository {
    fun getPagedCats(): Flow<PagingData<Cat>>
}