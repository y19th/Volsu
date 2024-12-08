package com.volsu.unijournal.subject.subject.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

internal sealed interface SubjectEvents: BaseEvents {

    data object OnNavigateBack: SubjectEvents
}