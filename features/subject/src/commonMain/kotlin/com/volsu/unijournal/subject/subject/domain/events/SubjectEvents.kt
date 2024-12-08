package com.volsu.unijournal.subject.subject.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType

internal sealed interface SubjectEvents: BaseEvents {

    data object OnNavigateBack: SubjectEvents

    data class OnNavigateToDetail(val type: DetailSubjectType): SubjectEvents
}