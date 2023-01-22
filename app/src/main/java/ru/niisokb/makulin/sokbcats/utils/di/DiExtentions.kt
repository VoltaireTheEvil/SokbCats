package ru.niisokb.makulin.sokbcats.utils.di

import android.content.Context
import ru.niisokb.makulin.sokbcats.App
import ru.niisokb.makulin.sokbcats.di.component.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }