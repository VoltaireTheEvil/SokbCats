package ru.niisokb.makulin.sokbcats.di.modules

import dagger.Binds
import dagger.Module
import ru.niisokb.makulin.sokbcats.data.repository.CatsRepository
import ru.niisokb.makulin.sokbcats.data.repository.RetrofitCatsRepositoryImpl

@Module
interface RepositoryModule {

    @Binds
    fun bindCatsRepository(implementation: RetrofitCatsRepositoryImpl): CatsRepository
}