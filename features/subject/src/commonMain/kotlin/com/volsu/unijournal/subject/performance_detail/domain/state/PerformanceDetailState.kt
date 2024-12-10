package com.volsu.unijournal.subject.performance_detail.domain.state

import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.BaseState

internal data class PerformanceDetailState(
    val user: String,
    val type: SubjectType
): BaseState
