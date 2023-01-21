package ru.niisokb.makulin.sokbcats.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.niisokb.makulin.sokbcats.di.annotations.CatApiKeyQualifier
import ru.niisokb.makulin.sokbcats.di.modules.DispatchersModule
import ru.niisokb.makulin.sokbcats.di.modules.NetworkModule

@Component(modules = [NetworkModule::class, DispatchersModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@CatApiKeyQualifier apiKey: String): Builder

        fun build(): AppComponent

    }
}