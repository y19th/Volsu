package com.volsu.unijournal.core.domain.use_cases.subject

import com.volsu.unijournal.core.domain.BaseUseCase
import com.volsu.unijournal.core.domain.mapper.toSubjectEntity
import com.volsu.unijournal.core.domain.models.Subject
import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.local.repository.SubjectsRepository
import kotlinx.coroutines.withContext

class InsertSubjectUseCase(
    dispatchers: VolsuDispatchers,
    private val repository: SubjectsRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke(model: Subject) = withContext(context) {
        repository.insert(model.toSubjectEntity())
    }
}