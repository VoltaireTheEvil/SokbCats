package ru.niisokb.makulin.sokbcats.di.modules

import dagger.Binds
import dagger.Module
import ru.niisokb.makulin.sokbcats.utils.downloader.Downloader
import ru.niisokb.makulin.sokbcats.utils.downloader.DownloaderImpl

@Module
interface DownloaderModule {

    @Binds
    fun bindDownloader(implementation: DownloaderImpl): Downloader
}