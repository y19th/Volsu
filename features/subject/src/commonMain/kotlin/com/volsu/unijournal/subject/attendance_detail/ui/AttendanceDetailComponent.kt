package com.volsu.unijournal.subject.attendance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.subject.attendance_detail.domain.events.AttendanceDetailEvents
import com.volsu.unijournal.subject.attendance_detail.domain.state.AttendanceDetailState
import com.volsu.unijournal.subject.root.SubjectNavigator

internal class AttendanceDetailComponent(
    componentContext: ComponentContext,
    user: String,
    private val navigator: SubjectNavigator
) : ScreenComponent<AttendanceDetailState, AttendanceDetailEvents>(
    initialState = AttendanceDetailState(user),
    componentContext = componentContext
) {
    override fun handleEvent(event: AttendanceDetailEvents) {
        when (event) {
            AttendanceDetailEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }
        }
    }

}