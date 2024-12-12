package com.volsu.unijournal.subject.performance_detail.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.domain.state.PerformanceDetailState
import com.volsu.unijournal.subject.performance_detail.ui.components.subject_lecture.EditableSubjectDetailLecture

@Suppress("unchecked_cast")
@Composable
internal fun PerformanceDetailUiBySubjectType(
    uncollectedState: State<PerformanceDetailState>,
    onSubjectChange: (DetailState) -> Unit,
    onAddSubject: () -> Unit
) {
    val state = uncollectedState.value

    when (state.type) {
        SubjectType.Laboratory -> {
            //TODO()
        }

        SubjectType.Lecture -> {
            EditableSubjectDetailLecture(
                initialState = state.detailState as List<DetailLecture>,
                editableMode = state.editableMode,
                onLectureChange = onSubjectChange,
                onAddLecture = onAddSubject
            )
        }

        SubjectType.Seminar -> {
            //TODO()
        }
    }
}