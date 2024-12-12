package com.volsu.unijournal.subject.attendance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.SnackState
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

            AttendanceDetailEvents.OnToggleEditableMode -> {
                update { it.copy(editableMode = !state.value.editableMode) }
                    .also {
                        state.value.editableMode.let { editable ->
                            val message = editable.editableMessage()
                            val snackState = if (editable)
                                SnackState.success(message) else SnackState.failure(message)

                            snackEffect(snackState)
                        }
                    }
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

            AttendanceDetailEvents.OnRejectChanges -> {
                update { it.copy(hasChanges = false, attendanceState = state.value.oldState) }
            }

            AttendanceDetailEvents.OnSaveChanges -> {
                update { it.copy(hasChanges = false, oldState = state.value.attendanceState) }
            }
        }
    }

    private fun Boolean.editableMessage(): String {
        return if (this)
            "Вы включили режим редактирования" else "Режим редактирования отключен"
    }
}