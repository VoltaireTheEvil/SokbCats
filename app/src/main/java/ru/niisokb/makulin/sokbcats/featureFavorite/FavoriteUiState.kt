package ru.niisokb.makulin.sokbcats.featureFavorite

import ru.niisokb.makulin.sokbcats.model.Cat

sealed class FavoriteUiState {
    data class SuccessLoading(val cats: List<Cat>) : FavoriteUiState()
    data class Error(val err: Throwable) : FavoriteUiState()
    object Nothing : FavoriteUiState()
    object SuccessDelete : FavoriteUiState()
}
