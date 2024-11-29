package com.volsu.unijournal.core.domain.use_cases.subject

import com.volsu.unijournal.core.domain.BaseUseCase
import com.volsu.unijournal.core.domain.mapper.toImmutableSubjectsList
import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.local.repository.SubjectsRepository
import kotlinx.coroutines.withContext

class ReceiveSubjectsUseCase(
    dispatchers: VolsuDispatchers,
    private val repository: SubjectsRepository
): BaseUseCase(dispatchers) {

    suspend operator fun invoke() = withContext(context) {
        repository.selectAll()
            .toImmutableSubjectsList()
    }
}