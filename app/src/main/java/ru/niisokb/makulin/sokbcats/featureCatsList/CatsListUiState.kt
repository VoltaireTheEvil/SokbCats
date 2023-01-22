package ru.niisokb.makulin.sokbcats.featureCatsList

sealed class CatsListUiState {
    data class Success(val message: String) : CatsListUiState()
    data class Error(val err: Throwable) : CatsListUiState()
    object Nothing : CatsListUiState()
}
