package ru.niisokb.makulin.sokbcats.di.modules

import dagger.Binds
import dagger.Module
import ru.niisokb.makulin.sokbcats.data.repository.CatsLocalRepository
import ru.niisokb.makulin.sokbcats.data.repository.CatsRemoteRepository
import ru.niisokb.makulin.sokbcats.data.repository.RetrofitCatsRemoteRepositoryImpl
import ru.niisokb.makulin.sokbcats.data.repository.RoomCatsLocalRepositoryImpl

@Module
interface RepositoryModule {

    @Binds
    fun bindRemoteRepository(implementation: RetrofitCatsRemoteRepositoryImpl): CatsRemoteRepository

    @Binds
    fun bindLocaleRepository(implementation: RoomCatsLocalRepositoryImpl): CatsLocalRepository

}