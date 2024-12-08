package com.volsu.unijournal.subject.subject.ui.components.role_subject.teacher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.subject.subject.domain.state.SubjectState
import com.volsu.unijournal.subject.subject.ui.components.SubjectTitle

@Composable
internal fun TeacherSubject(state: State<SubjectState>) {
    VerticalSpacer(height = 24.dp)

    SubjectTitle(
        subjectName = state.value.subject,
        subjectForm = state.value.form
    )

    VerticalSpacer(height = 24.dp)

    TeacherSubjectContent()
}