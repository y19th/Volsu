package com.volsu.unijournal.core.local.repository

import com.volsu.unijournal.core.local.dao.SubjectDao
import com.volsu.unijournal.core.local.entities.subjects.SubjectEntity

interface SubjectsRepository {

    suspend fun insert(entity: SubjectEntity)

    suspend fun selectAll(): List<SubjectEntity>
}

internal class SubjectsRepositoryImpl(
    private val dao: SubjectDao
): SubjectsRepository {
    override suspend fun insert(entity: SubjectEntity) {
        dao.insert(entity)
    }

    override suspend fun selectAll(): List<SubjectEntity> {
        return dao.selectAll()
    }
}