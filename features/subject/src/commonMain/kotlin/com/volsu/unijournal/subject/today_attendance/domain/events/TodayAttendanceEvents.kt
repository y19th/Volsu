package com.volsu.unijournal.subject.today_attendance.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents
import com.volsu.unijournal.subject.today_attendance.domain.models.TodayAttendance

internal sealed interface TodayAttendanceEvents: BaseEvents {

    data object OnNavigateBack: TodayAttendanceEvents

    data object OnToggleEditableState: TodayAttendanceEvents

    data object OnDiscardChanges: TodayAttendanceEvents

    data object OnCommitChanges: TodayAttendanceEvents

    data class OnEditAttend(val attend: TodayAttendance): TodayAttendanceEvents
}