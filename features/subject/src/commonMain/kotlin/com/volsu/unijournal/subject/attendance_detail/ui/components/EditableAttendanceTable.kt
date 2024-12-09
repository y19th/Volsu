package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.util.extension.noIndicationClickable
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend
import com.volsu.unijournal.subject.subject.domain.models.attendanceMark

@Composable
internal fun EditableAttendanceTable(
    initialAttendance: List<Attend>,
    modifier: Modifier = Modifier,
    onAddNewAttend: () -> Unit,
    onEditAttend: (Attend) -> Unit
) {
    val attendanceState = rememberUpdatedState(initialAttendance)

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
        attendanceState.value.forEach { item ->
            AttendanceTableItem(
                attend = item,
                onEditAttend = onEditAttend
            )
        }

        EmptyAttendanceTableItem(onAddNewAttend)
    }
}

@Composable
private fun AttendanceTableItem(
    attend: Attend,
    onEditAttend: (Attend) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AttendanceTableCell(
            modifier = Modifier
                .weight(0.5f),
            value = attend.date,
            onValueChange = {
                onEditAttend(attend.copy(date = it))
            }
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        AttendanceCheckbox(
            initialValue = attend.was.boolean,
            onValueChange = {
                onEditAttend(attend.copy(was = it.attendanceMark()))
            }
        )
    }

    HorizontalDivider()
}

@Composable
private fun EmptyAttendanceTableItem(
    onFirstClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .noIndicationClickable(onClick = onFirstClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(0.5f),
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        AttendanceCheckbox(
            initialValue = false,
            onValueChange = {}
        )
    }
}