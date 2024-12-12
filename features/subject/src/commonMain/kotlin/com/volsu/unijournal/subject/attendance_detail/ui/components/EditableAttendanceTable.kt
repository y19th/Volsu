package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend
import com.volsu.unijournal.subject.attendance_detail.domain.state.AttendanceDetailState

@Composable
internal fun EditableAttendanceTable(
    uncollectedState: State<AttendanceDetailState>,
    modifier: Modifier = Modifier,
    onAddNewAttend: () -> Unit,
    onEditAttend: (Attend) -> Unit
) {
    val attendanceState = uncollectedState.value
    val passed = remember(attendanceState.attendanceState) {
        derivedStateOf { attendanceState.attendanceState.count { it.was.boolean } }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(vertical = 16.dp, horizontal = 12.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        AttendanceTableItemHeader()

        attendanceState.attendanceState.forEach { item ->
            AttendanceTableItem(
                attend = item,
                editable = attendanceState.editableMode,
                onEditAttend = onEditAttend
            )
        }

        EmptyAttendanceTableItem(
            editable = attendanceState.editableMode,
            onFirstClick = onAddNewAttend
        )
    }

    VerticalSpacer(height = 16.dp)

    AttendanceTotalCell(
        passed = passed.value,
        total = attendanceState.attendanceState.size
    )
}


