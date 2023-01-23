package ru.niisokb.makulin.sokbcats.featureDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.niisokb.makulin.sokbcats.utils.downloader.Downloader
import javax.inject.Inject
import javax.inject.Provider

class DetailsViewModel(
    private val downloader: Downloader
) : ViewModel() {

    fun downloadImage(url: String) {
        downloader.downloadFile(url = url)
    }


    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val downloaderProvider: Provider<Downloader>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == DetailsViewModel::class.java)
            return DetailsViewModel(
                downloader = downloaderProvider.get()
            ) as T
        }
    }
}