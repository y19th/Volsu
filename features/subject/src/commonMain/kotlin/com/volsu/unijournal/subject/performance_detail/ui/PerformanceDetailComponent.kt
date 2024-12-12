package com.volsu.unijournal.subject.performance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.SnackState
import com.volsu.unijournal.subject.performance_detail.domain.events.PerformanceDetailEvents
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLaboratory
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailSeminar
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.domain.models.testDetailLaboratoryState
import com.volsu.unijournal.subject.performance_detail.domain.models.testDetailLectureState
import com.volsu.unijournal.subject.performance_detail.domain.models.testDetailSeminarState
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
        type.testState().let { state ->
            update {
                it.copy(
                    detailState = state,
                    oldState = state
                )
            }
        }
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
                            val message = editable.editableMessage()
                            val snackState = if (editable)
                                SnackState.success(message) else SnackState.failure(message)

                            snackEffect(snackState)
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
                    it.copy(detailState = newList, hasChanges = true)
                }
            }

            is PerformanceDetailEvents.OnSubjectChange -> {
                val newList = state.value.detailState
                    .map { item ->
                        if (item.id() == event.subject.id()) event.subject else item
                    }.sortedBy {
                        it.first().millis
                    }

                val hasChange = with(state.value.detailState) {
                    size != newList.size || this != newList
                }

                update {
                    it.copy(
                        detailState = newList,
                        hasChanges = hasChange
                    )
                }
            }

            PerformanceDetailEvents.OnRejectChanges -> {
                update { it.copy(hasChanges = false, detailState = state.value.oldState) }
            }

            PerformanceDetailEvents.OnSaveChanges -> {
                update { it.copy(hasChanges = false, oldState = state.value.detailState) }
            }
        }
    }

    private fun receiveEmptyInstance(id: Int): DetailState {
        return when (state.value.type) {
            is SubjectType.Lecture -> {
                DetailLecture.idEmpty(id)
            }

            is SubjectType.Laboratory -> {
                DetailLaboratory.idEmpty(id)
            }

            is SubjectType.Seminar -> {
                DetailSeminar.idEmpty(id)
            }
        }
    }

    private fun SubjectType.testState(): List<DetailState> = when (this) {
        SubjectType.Laboratory -> {
            DetailLaboratory.testDetailLaboratoryState()
        }

        SubjectType.Lecture -> {
            DetailLecture.testDetailLectureState()
        }

        SubjectType.Seminar -> {
            DetailSeminar.testDetailSeminarState()
        }
    }

    private fun Boolean.editableMessage(): String {
        return if (this)
            "Вы включили режим редактирования" else "Режим редактирования отключен"
    }
}