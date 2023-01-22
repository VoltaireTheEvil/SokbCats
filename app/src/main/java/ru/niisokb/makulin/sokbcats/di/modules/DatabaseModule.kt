package ru.niisokb.makulin.sokbcats.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.niisokb.makulin.sokbcats.data.room.CatDao
import ru.niisokb.makulin.sokbcats.data.room.CatDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @[Singleton Provides]
    fun providesDb(context: Context): CatDatabase = Room
        .databaseBuilder(
            context = context,
            klass = CatDatabase::class.java,
            name = DB_NAME
        )
        .build()

    @[Singleton Provides]
    fun providesCatDao(database: CatDatabase): CatDao = database.getCatDao()

    companion object {
        const val DB_NAME = "catDb.db"
    }
}