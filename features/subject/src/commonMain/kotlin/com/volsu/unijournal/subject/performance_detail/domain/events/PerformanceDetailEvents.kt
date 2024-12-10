package com.volsu.unijournal.subject.performance_detail.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState

internal sealed interface PerformanceDetailEvents: BaseEvents {

    data object OnNavigateBack: PerformanceDetailEvents

    data object OnAddSubject: PerformanceDetailEvents

    data class OnSubjectChange(val subject: DetailState): PerformanceDetailEvents
}