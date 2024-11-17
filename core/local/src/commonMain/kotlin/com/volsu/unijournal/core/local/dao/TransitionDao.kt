package com.volsu.unijournal.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.volsu.unijournal.core.local.entities.TransitionEntity
import com.volsu.unijournal.core.util.models.Transition

@Dao
interface TransitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(step: TransitionEntity)

    @Query("select step from transition")
    suspend fun receive(): Transition?
}