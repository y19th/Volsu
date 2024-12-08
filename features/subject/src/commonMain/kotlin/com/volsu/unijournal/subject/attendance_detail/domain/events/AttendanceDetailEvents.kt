package com.volsu.unijournal.subject.attendance_detail.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

internal sealed interface AttendanceDetailEvents : BaseEvents {

    data object OnNavigateBack : AttendanceDetailEvents
}