package ru.niisokb.makulin.sokbcats.featureFavorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.niisokb.makulin.sokbcats.data.repository.local.CatsLocalRepository
import ru.niisokb.makulin.sokbcats.model.Cat
import javax.inject.Inject
import javax.inject.Provider

class FavoriteViewModel(
    private val localRepository: CatsLocalRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<FavoriteUiState> =
        MutableStateFlow(FavoriteUiState.Nothing)

    val uiState: StateFlow<FavoriteUiState> = _uiState

    fun getFavoriteCats() {
        viewModelScope.launch {
            _uiState.emit(FavoriteUiState.Nothing)
            try {
                val cats = localRepository.getAllFavorites()
                _uiState.emit(FavoriteUiState.SuccessLoading(cats = cats))
            } catch (e: Exception) {
                _uiState.emit(FavoriteUiState.Error(err = e))
            }
        }
    }

    fun deleteCat(cat: Cat) {
        viewModelScope.launch {
            _uiState.emit(FavoriteUiState.Nothing)
            try {
                val cats = localRepository.delete(cat = cat)
                _uiState.emit(FavoriteUiState.SuccessDelete)
            } catch (e: Exception) {
                _uiState.emit(FavoriteUiState.Error(err = e))
            }
        }
    }


    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val localRepositoryProvider: Provider<CatsLocalRepository>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == FavoriteViewModel::class.java)
            return FavoriteViewModel(
                localRepository = localRepositoryProvider.get()
            ) as T
        }
    }

}