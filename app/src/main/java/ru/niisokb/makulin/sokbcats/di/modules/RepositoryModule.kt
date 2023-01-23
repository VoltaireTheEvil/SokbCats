package ru.niisokb.makulin.sokbcats.di.modules

import dagger.Binds
import dagger.Module
import ru.niisokb.makulin.sokbcats.data.repository.local.CatsLocalRepository
import ru.niisokb.makulin.sokbcats.data.repository.remote.CatsRemoteRepository
import ru.niisokb.makulin.sokbcats.data.repository.remote.RetrofitCatsRemoteRepositoryImpl
import ru.niisokb.makulin.sokbcats.data.repository.local.RoomCatsLocalRepositoryImpl

@Module
interface RepositoryModule {

    @Binds
    fun bindRemoteRepository(implementation: RetrofitCatsRemoteRepositoryImpl): CatsRemoteRepository

    @Binds
    fun bindLocaleRepository(implementation: RoomCatsLocalRepositoryImpl): CatsLocalRepository

}