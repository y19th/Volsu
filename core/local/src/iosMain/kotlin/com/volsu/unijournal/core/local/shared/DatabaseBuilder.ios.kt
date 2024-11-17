package com.volsu.unijournal.core.local.shared

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.volsu.unijournal.core.local.database.MainDatabase
import com.volsu.unijournal.core.util.local.Handler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual val databaseBuilder: DatabaseBuilder = IosDatabaseBuilder()

internal class IosDatabaseBuilder: DatabaseBuilder {
    override fun create(path: String): MainDatabase {
        return Room.databaseBuilder<MainDatabase>(
            name = path
        ).fallbackToDestructiveMigrationOnDowngrade(true)
            .setQueryCoroutineContext(Handler.coroutineExceptionHandler + Dispatchers.IO)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}