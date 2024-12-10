package com.volsu.unijournal.subject.detail.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

internal sealed interface DetailEvents: BaseEvents {

    data object OnNavigateBack: DetailEvents

    data class OnNavigateToUserAttendance(val user: String): DetailEvents

    data class OnNavigateToUserPerformance(val user: String): DetailEvents
}