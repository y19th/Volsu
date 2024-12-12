package com.volsu.unijournal.subject.performance_detail.domain.state

import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState

internal data class PerformanceDetailState(
    val user: String,
    val type: SubjectType,
    val editableMode: Boolean = false,

    val detailState: List<DetailState> = listOf()
) : BaseState
