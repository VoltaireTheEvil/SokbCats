package ru.niisokb.makulin.sokbcats.featureCatsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import ru.niisokb.makulin.sokbcats.data.repository.CatsRepository
import ru.niisokb.makulin.sokbcats.model.Cat
import javax.inject.Inject
import javax.inject.Provider

class CatsListViewModel(
    private val catsRepository: CatsRepository
) : ViewModel() {

    val catsFlow: Flow<PagingData<Cat>> = catsRepository.getPagedCats().cachedIn(viewModelScope)

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val repositoryProvider: Provider<CatsRepository>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CatsListViewModel::class.java)
            return CatsListViewModel(catsRepository = repositoryProvider.get()) as T
        }
    }
}