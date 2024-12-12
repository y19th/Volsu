package com.volsu.unijournal.subject.performance_detail.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLaboratory
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailSeminar
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.domain.state.PerformanceDetailState
import com.volsu.unijournal.subject.performance_detail.ui.components.subject_laboratory.EditableSubjectDetailLaboratory
import com.volsu.unijournal.subject.performance_detail.ui.components.subject_lecture.EditableSubjectDetailLecture
import com.volsu.unijournal.subject.performance_detail.ui.components.subject_seminar.EditableSubjectDetailSeminar

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
            EditableSubjectDetailLaboratory(
                initialState = state.detailState as List<DetailLaboratory>,
                editableMode = state.editableMode,
                onLectureChange = onSubjectChange,
                onAddLecture = onAddSubject
            )
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
            EditableSubjectDetailSeminar(
                initialState = state.detailState as List<DetailSeminar>,
                editableMode = state.editableMode,
                onSeminarChange = onSubjectChange,
                onAddSeminar = onAddSubject
            )
        }
    }
}