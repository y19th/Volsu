package com.volsu.unijournal.core.local.shared

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.volsu.unijournal.core.local.database.MainDatabase
import com.volsu.unijournal.core.util.local.Handler
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

actual val databaseBuilder: DatabaseBuilder = AndroidDatabaseBuilder()

internal class AndroidDatabaseBuilder: DatabaseBuilder, KoinComponent {

    private val context: Context get() = get()

    override fun create(path: String): MainDatabase {
        return Room.databaseBuilder<MainDatabase>(
            context = context,
            name = path
        ).fallbackToDestructiveMigrationOnDowngrade(true)
            .setQueryCoroutineContext(Handler.coroutineExceptionHandler + Dispatchers.IO)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}