package com.volsu.unijournal.subject.attendance_detail.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState

internal data class AttendanceDetailState(
    val user: String
): BaseState
