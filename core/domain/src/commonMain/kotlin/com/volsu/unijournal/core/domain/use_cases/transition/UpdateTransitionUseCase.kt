package com.volsu.unijournal.core.domain.use_cases.transition

import com.volsu.unijournal.core.domain.BaseUseCase
import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.local.entities.TransitionEntity
import com.volsu.unijournal.core.local.repository.TransitionRepository
import com.volsu.unijournal.core.util.models.Transition
import kotlinx.coroutines.withContext

class UpdateTransitionUseCase(
    dispatcher: VolsuDispatchers,
    private val repository: TransitionRepository
) : BaseUseCase(dispatcher) {
    suspend operator fun invoke(transition: Transition) = withContext(context) {
        repository.update(TransitionEntity(step = transition))
    }
}