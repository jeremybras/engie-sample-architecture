package com.octo.archiexampleengie.android

import android.arch.persistence.room.Room
import android.content.Context
import com.octo.archiexampleengie.repository.common.db.EngieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideEngieDatabase(context: Context): EngieDatabase =
        Room.databaseBuilder(context, EngieDatabase::class.java, "ehs-numengie")
            .fallbackToDestructiveMigration()
            .build()
}
