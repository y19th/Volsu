package com.volsu.unijournal.subject.subject.domain.state

import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.util.base_components.BaseState

internal data class SubjectState(
    val subject: String,
    val form: SubjectForm
): BaseState
