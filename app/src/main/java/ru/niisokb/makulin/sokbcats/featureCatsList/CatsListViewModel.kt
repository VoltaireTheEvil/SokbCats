package ru.niisokb.makulin.sokbcats.featureCatsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.niisokb.makulin.sokbcats.data.repository.local.CatsLocalRepository
import ru.niisokb.makulin.sokbcats.data.repository.remote.CatsRemoteRepository
import ru.niisokb.makulin.sokbcats.model.Cat
import javax.inject.Inject
import javax.inject.Provider

class CatsListViewModel(
    private val catsRemoteRepository: CatsRemoteRepository,
    private val catsLocalRepository: CatsLocalRepository
) : ViewModel() {

    val catsFlow: Flow<PagingData<Cat>> =
        catsRemoteRepository.getPagedCats().cachedIn(viewModelScope)

    private val _uiState: MutableStateFlow<CatsListUiState> =
        MutableStateFlow(CatsListUiState.Nothing)

    val uiState: StateFlow<CatsListUiState> = _uiState

    fun addToFavorite(cat: Cat) {
        viewModelScope.launch {
            _uiState.emit(CatsListUiState.Nothing)
            try {
                catsLocalRepository.addToFavorite(cat)
                _uiState.emit(CatsListUiState.Success(SUCCESS_MESSAGE))
            } catch (e: Exception) {
                _uiState.emit(CatsListUiState.Error(e))
            }
        }
    }

    companion object {
        const val SUCCESS_MESSAGE = "Добавлено в избранное"
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val remoteRepositoryProvider: Provider<CatsRemoteRepository>,
        private val localRepositoryProvider: Provider<CatsLocalRepository>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == CatsListViewModel::class.java)
            return CatsListViewModel(
                catsRemoteRepository = remoteRepositoryProvider.get(),
                catsLocalRepository = localRepositoryProvider.get()
            ) as T
        }
    }
}