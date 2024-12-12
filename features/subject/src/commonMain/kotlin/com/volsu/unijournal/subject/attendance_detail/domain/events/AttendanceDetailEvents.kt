package com.volsu.unijournal.subject.attendance_detail.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend

internal sealed interface AttendanceDetailEvents : BaseEvents {

    data object OnNavigateBack : AttendanceDetailEvents

    data object OnAddNewAttend : AttendanceDetailEvents

    data object OnToggleEditableMode: AttendanceDetailEvents

    data object OnSaveChanges: AttendanceDetailEvents

    data object OnRejectChanges: AttendanceDetailEvents

    data class OnEditAttend(val attend: Attend) : AttendanceDetailEvents
}