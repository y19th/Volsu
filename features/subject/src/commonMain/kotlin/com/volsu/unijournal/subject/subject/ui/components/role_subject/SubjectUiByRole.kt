package com.volsu.unijournal.subject.subject.ui.components.role_subject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import com.volsu.unijournal.core.util.models.Role
import com.volsu.unijournal.subject.subject.domain.state.SubjectState
import com.volsu.unijournal.subject.subject.ui.components.role_subject.student.StudentSubject
import com.volsu.unijournal.subject.subject.ui.components.role_subject.teacher.TeacherSubject

@Composable
internal fun SubjectUiByRole(
    role: Role,
    uncollectedState: State<SubjectState>
) {
    val state = rememberUpdatedState(role)

    when(state.value) {
        Role.Student -> {
            StudentSubject(uncollectedState)
        }
        Role.Teacher -> {
            TeacherSubject(uncollectedState)
        }
    }
}