package com.volsu.unijournal.core.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.volsu.unijournal.core.local.converters.TransitionConverter
import com.volsu.unijournal.core.local.dao.TransitionDao
import com.volsu.unijournal.core.local.entities.TransitionEntity


@Database(
    entities = [TransitionEntity::class],
    version = 1
)
@TypeConverters(TransitionConverter::class)
@ConstructedBy(MainDatabaseConstructor::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun transitionDao(): TransitionDao


}


expect object MainDatabaseConstructor : RoomDatabaseConstructor<MainDatabase>
