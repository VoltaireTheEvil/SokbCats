package ru.niisokb.makulin.sokbcats

import android.app.Application
import ru.niisokb.makulin.sokbcats.di.component.DaggerAppComponent

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .apiKey(BuildConfig.CATS_API_KEY)
            .build()
    }

}