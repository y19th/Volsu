package com.volsu.unijournal.core.domain.use_cases.transition

import com.volsu.unijournal.core.domain.BaseUseCase
import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.local.repository.TransitionRepository
import com.volsu.unijournal.core.util.models.Transition
import kotlinx.coroutines.withContext

class ReceiveTransitionUseCase(
    dispatcher: VolsuDispatchers,
    private val repository: TransitionRepository
): BaseUseCase(dispatcher) {
    suspend operator fun invoke(): Transition = withContext(context) {
        repository.receive()
    }
}