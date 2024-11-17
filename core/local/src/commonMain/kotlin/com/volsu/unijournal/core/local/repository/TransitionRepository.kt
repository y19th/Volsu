package com.volsu.unijournal.core.local.repository

import com.volsu.unijournal.core.local.dao.TransitionDao
import com.volsu.unijournal.core.local.entities.TransitionEntity
import com.volsu.unijournal.core.util.models.Transition

interface TransitionRepository {

    suspend fun update(entity: TransitionEntity)

    suspend fun receive(): Transition
}

internal class TransitionRepositoryImpl(
    private val dao: TransitionDao
): TransitionRepository {
    override suspend fun update(entity: TransitionEntity) {
        dao.insert(entity)
    }

    override suspend fun receive(): Transition {
        return dao.receive() ?: Transition.None
    }
}