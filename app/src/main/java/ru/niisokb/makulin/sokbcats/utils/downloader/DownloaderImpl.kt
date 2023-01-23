package ru.niisokb.makulin.sokbcats.utils.downloader

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import javax.inject.Inject

class DownloaderImpl @Inject constructor(
    context: Context
) : Downloader {

    private val downloaderManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/*")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, SUB_PATH)
        return downloaderManager.enqueue(request)
    }

    companion object {
        const val SUB_PATH = "downloadedCat"
    }
}