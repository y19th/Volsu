package com.volsu.unijournal.subject.subject.ui.components.role_subject.student

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.subject.subject.domain.state.SubjectState
import com.volsu.unijournal.subject.subject.ui.components.SubjectTitle
import com.volsu.unijournal.subject.subject.ui.components.subject_class.SubjectClassification

@Composable
internal fun StudentSubject(state: State<SubjectState>) {
    VerticalSpacer(height = 24.dp)

    SubjectTitle(
        subjectName = state.value.subject,
        subjectForm = state.value.form
    )

    VerticalSpacer(height = 12.dp)

    SubjectClassification(
        subjectForm = state.value.form
    )
}