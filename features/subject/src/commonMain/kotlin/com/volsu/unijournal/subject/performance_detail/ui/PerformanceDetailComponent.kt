package com.volsu.unijournal.subject.performance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.SnackState
import com.volsu.unijournal.subject.performance_detail.domain.events.PerformanceDetailEvents
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.domain.models.testDetailLectureState
import com.volsu.unijournal.subject.performance_detail.domain.state.PerformanceDetailState
import com.volsu.unijournal.subject.root.SubjectNavigator

internal class PerformanceDetailComponent(
    componentContext: ComponentContext,
    user: String,
    type: SubjectType,
    private val navigator: SubjectNavigator
) : ScreenComponent<PerformanceDetailState, PerformanceDetailEvents>(
    initialState = PerformanceDetailState(user, type),
    componentContext = componentContext
) {
    init {
        update { it.copy(detailState = DetailLecture.testDetailLectureState()) }
    }

    override fun handleEvent(event: PerformanceDetailEvents) {
        when (event) {
            PerformanceDetailEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            PerformanceDetailEvents.OnToggleEditableMode -> {
                update { it.copy(editableMode = !state.value.editableMode) }
                    .also {
                        state.value.editableMode.let { editable ->
                            val snackState = if (editable)
                                SnackState.success(editable.editableMessage()) else SnackState.failure(editable.editableMessage())
                        }
                    }
            }

            PerformanceDetailEvents.OnAddSubject -> {
                val newId = state.value.detailState
                    .maxBy { it.id() }
                    .id()
                    .plus(1)

                val newList = state.value.detailState
                    .plus(receiveEmptyInstance(newId))

                update {
                    it.copy(detailState = newList)
                }
            }

            is PerformanceDetailEvents.OnSubjectChange -> {
                val newList = state.value.detailState
                    .map { item ->
                        if (item.id() == event.subject.id()) event.subject else item
                    }

                update { it.copy(detailState = newList) }
            }
        }
    }

    private fun receiveEmptyInstance(id: Int): DetailState {
        return when (state.value.detailState.firstOrNull()) {
            is DetailLecture -> {
                DetailLecture.idEmpty(id)
            }

            null -> {
                throw NullPointerException("null")
            }
        }
    }

    private fun Boolean.editableMessage(): String {
        return if (this)
            "Вы включили режим редактирования" else "Режим редактирования отключен"
    }
}