package com.octo.archiexampleengie.repository.common.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.octo.archiexampleengie.repository.workorders.db.UserDao
import com.octo.archiexampleengie.repository.workorders.db.UserDb

@Database(entities = [
    UserDb::class
], version = 2)
@TypeConverters(Converters::class)
abstract class EngieDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
