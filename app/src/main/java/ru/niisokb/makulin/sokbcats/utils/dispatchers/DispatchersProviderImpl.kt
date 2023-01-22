package ru.niisokb.makulin.sokbcats.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatchersProviderImpl @Inject constructor() : DispatchersProvider {

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun ui(): CoroutineDispatcher = Dispatchers.Main

}