package com.volsu.unijournal.subject.today_attendance.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.mapper.asGroupModel
import com.volsu.unijournal.core.domain.mapper.toSubjectForm
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.GroupConfig
import com.volsu.unijournal.core.util.models.SnackState
import com.volsu.unijournal.subject.extension.editableMessage
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.today_attendance.domain.events.TodayAttendanceEvents
import com.volsu.unijournal.subject.today_attendance.domain.models.testTodayAttendanceState
import com.volsu.unijournal.subject.today_attendance.domain.state.TodayAttendanceState

internal class TodayAttendanceComponent(
    componentContext: ComponentContext,
    type: SubjectType,
    group: GroupConfig,
    private val navigator: SubjectNavigator
) : ScreenComponent<TodayAttendanceState, TodayAttendanceEvents>(
    initialState = TodayAttendanceState(
        group = group.asGroupModel(),
        subjectType = type.toSubjectForm()
    ),
    componentContext = componentContext
) {
    init {
        testTodayAttendanceState().let { newState ->
            update {
                it.copy(
                    attendance = newState,
                    oldState = newState
                )
            }
        }
    }

    override fun handleEvent(event: TodayAttendanceEvents) = when (event) {
        TodayAttendanceEvents.OnNavigateBack -> {
            navigate { navigator.pop() }
        }

        TodayAttendanceEvents.OnToggleEditableState -> {
            update { it.copy(editableState = !state.value.editableState) }
                .also {
                    state.value.editableState.let { editable ->
                        val message = editable.editableMessage()
                        val snackState = if (editable)
                            SnackState.success(message) else SnackState.failure(message)

                        snackEffect(snackState)
                    }
                }
        }


        is TodayAttendanceEvents.OnEditAttend -> {
            val newList = state.value.attendance
                .map { if (it.id == event.attend.id) event.attend else it }
            val hasChanges = with(state.value) {
                newList != oldState
            }

            update { it.copy(hasChanges = hasChanges, attendance = newList) }
        }

        TodayAttendanceEvents.OnCommitChanges -> {
            update { it.copy(hasChanges = false, oldState = state.value.attendance) }
        }

        TodayAttendanceEvents.OnDiscardChanges -> {
            update { it.copy(hasChanges = false, attendance = state.value.oldState) }
        }
    }
}