package ru.niisokb.makulin.sokbcats.utils.downloader

interface Downloader {
    fun downloadFile(url: String): Long
}