package ru.niisokb.makulin.sokbcats.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {

    fun io(): CoroutineDispatcher

    fun ui(): CoroutineDispatcher

}