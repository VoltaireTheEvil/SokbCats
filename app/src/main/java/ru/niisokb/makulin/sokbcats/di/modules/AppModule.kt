package ru.niisokb.makulin.sokbcats.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DispatchersModule::class])
class AppModule {

    @[Provides Singleton]
    fun context(application: Application): Context = application.applicationContext
}