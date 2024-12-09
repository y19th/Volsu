package com.volsu.unijournal.subject.detail.ui.components

import androidx.compose.runtime.Composable
import com.volsu.unijournal.subject.detail.domain.models.DetailSubjectState
import com.volsu.unijournal.subject.detail.ui.components.subject_ui.attendance.AttendanceUi
import com.volsu.unijournal.subject.detail.ui.components.subject_ui.performance.PerformanceUi
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType

@Composable
internal fun DetailUiSubjectType(
    type: DetailSubjectType,
    onAttendanceClick: (String) -> Unit
) {
    when (type) {
        DetailSubjectType.Attendance -> {
            AttendanceUi(
                state = DetailSubjectState.Attendance.testState,
                onUserClick = onAttendanceClick
            )
        }

        is DetailSubjectType.Performance -> {
            PerformanceUi()
        }
    }
}