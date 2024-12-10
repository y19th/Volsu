package com.volsu.unijournal.subject.performance_detail.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.domain.models.testDetailLectureState
import com.volsu.unijournal.subject.performance_detail.ui.components.subject_lecture.EditableSubjectDetailLecture

@Composable
internal fun PerformanceDetailUiBySubjectType(
    type: SubjectType,
    onSubjectChange: (DetailState) -> Unit,
    onAddSubject: () -> Unit
) {
    val state = rememberUpdatedState(type)

    when(state.value) {
        SubjectType.Laboratory -> {
            //TODO()
        }
        SubjectType.Lecture -> {
            EditableSubjectDetailLecture(
                initialState = DetailLecture.testDetailLectureState(),
                onLectureChange = onSubjectChange,
                onAddLecture = onAddSubject
            )
        }
        SubjectType.Seminar -> {
            //TODO()
        }
    }
}