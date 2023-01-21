package ru.niisokb.makulin.sokbcats.di.modules

import dagger.Binds
import dagger.Module
import ru.niisokb.makulin.sokbcats.utils.dispatchers.DispatchersProvider
import ru.niisokb.makulin.sokbcats.utils.dispatchers.DispatchersProviderImpl

@Module
interface DispatchersModule {

    @Binds
    fun bindDispatcherProvider(implementation: DispatchersProviderImpl): DispatchersProvider

}