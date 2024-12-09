package com.volsu.unijournal.subject.attendance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.subject.attendance_detail.domain.events.AttendanceDetailEvents
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend
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
    init {
        update { it.copy(attendanceState = Attend.testState) }
    }

    override fun handleEvent(event: AttendanceDetailEvents) {
        when (event) {
            AttendanceDetailEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            is AttendanceDetailEvents.OnAddNewAttend -> {
                val newId = state.value.attendanceState
                    .maxBy { it.id }
                    .id
                    .plus(1)

                val newList = state.value.attendanceState
                    .plus(Attend.empty(newId))

                update {
                    it.copy(attendanceState = newList)
                }
            }

            is AttendanceDetailEvents.OnEditAttend -> {
                val newList = state.value.attendanceState
                    .map { item ->
                        if (item.id == event.attend.id) event.attend else item
                    }

                update { it.copy(attendanceState = newList) }
            }
        }
    }

}