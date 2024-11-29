package com.volsu.unijournal.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.volsu.unijournal.core.local.entities.subjects.SubjectEntity

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: SubjectEntity)

    @Query("select * from subjects")
    suspend fun selectAll(): List<SubjectEntity>
}