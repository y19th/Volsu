package com.volsu.unijournal.subject.today_attendance.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.subject.attendance_detail.ui.components.AttendanceCheckbox
import com.volsu.unijournal.subject.today_attendance.domain.models.TodayAttendance

private const val checkboxWeight = 0.25f
private const val dateWeight = 0.5f

@Composable
internal fun TodayAttendanceItem(
    editable: Boolean,
    item: TodayAttendance,
    isLastItem: Boolean,
    onEditAttend: (TodayAttendance) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TodayAttendanceNameCell(
            modifier = Modifier
                .weight(dateWeight),
            name = item.name
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        AttendanceCheckbox(
            modifier = Modifier
                .weight(checkboxWeight),
            initialValue = item.was,
            editable = editable,
            onValueChange = {
                onEditAttend(item.copy(was = it))
            }
        )
    }

    if (!isLastItem)
        HorizontalDivider()
}