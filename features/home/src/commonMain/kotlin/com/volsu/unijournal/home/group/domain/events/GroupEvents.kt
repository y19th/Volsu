package com.volsu.unijournal.home.group.domain.events

import com.volsu.unijournal.core.domain.models.Subject
import com.volsu.unijournal.core.util.base_components.BaseEvents

internal sealed interface GroupEvents: BaseEvents {

    data object OnNavigateBack: GroupEvents

    data object OnNavigateToSettings: GroupEvents

    data class OnNavigateToSubject(val subject: Subject): GroupEvents
}