package com.volsu.unijournal.subject.attendance_detail.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend

internal data class AttendanceDetailState(
    val user: String,
    val attendanceState: List<Attend> = listOf()
): BaseState
