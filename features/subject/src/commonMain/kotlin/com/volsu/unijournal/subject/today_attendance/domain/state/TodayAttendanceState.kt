package com.volsu.unijournal.subject.today_attendance.domain.state

import com.volsu.unijournal.core.domain.models.Group
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.subject.today_attendance.domain.models.TodayAttendance

internal data class TodayAttendanceState(
    val attendance: List<TodayAttendance> = listOf(),
    val editableState: Boolean = false,
    val group: Group,
    val subjectType: SubjectForm,

    val hasChanges: Boolean = false,
    val oldState: List<TodayAttendance> = listOf()
): BaseState
