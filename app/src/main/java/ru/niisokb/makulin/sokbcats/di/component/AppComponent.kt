package ru.niisokb.makulin.sokbcats.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.niisokb.makulin.sokbcats.di.annotations.CatApiKeyQualifier
import ru.niisokb.makulin.sokbcats.di.modules.AppModule
import ru.niisokb.makulin.sokbcats.featureCatsList.CatsListFragment
import ru.niisokb.makulin.sokbcats.featureDetails.DetailsFragment
import ru.niisokb.makulin.sokbcats.featureFavorite.FavoriteFragment
import javax.inject.Singleton

@[Singleton Component(modules = [AppModule::class])]
interface AppComponent {

    fun inject(fragment: CatsListFragment)

    fun inject(fragment: FavoriteFragment)

    fun inject(fragment: DetailsFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@CatApiKeyQualifier apiKey: String): Builder

        fun build(): AppComponent

    }
}