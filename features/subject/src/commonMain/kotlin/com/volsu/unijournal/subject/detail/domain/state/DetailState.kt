package com.volsu.unijournal.subject.detail.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType

internal data class DetailState(
    val type: DetailSubjectType
): BaseState
