package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.util.extension.noIndicationClickable
import com.volsu.unijournal.core.util.models.VolsuDate
import com.volsu.unijournal.subject.attendance_detail.domain.models.Attend
import com.volsu.unijournal.subject.subject.domain.models.attendanceMark


private const val checkboxWeight = 0.25f
private const val dateWeight = 0.5f

@Composable
internal fun AttendanceTableItem(
    attend: Attend,
    editable: Boolean,
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
                .weight(dateWeight),
            value = attend.date,
            editable = editable,
            onValueChange = {
                onEditAttend(attend.copy(date = VolsuDate(it)))
            }
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        AttendanceCheckbox(
            modifier = Modifier
                .weight(checkboxWeight),
            initialValue = attend.was.boolean,
            editable = editable,
            onValueChange = {
                onEditAttend(attend.copy(was = it.attendanceMark()))
            }
        )
    }

    HorizontalDivider()
}

@Composable
internal fun AttendanceTableItemHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextMedium(
            modifier = Modifier
                .weight(dateWeight),
            fontSize = 16.sp,
            text = "Дата занятия"
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        TextMedium(
            modifier = Modifier
                .weight(checkboxWeight),
            fontSize = 16.sp,
            text = "Посещение"
        )
    }

    HorizontalDivider()
}

@Composable
internal fun EmptyAttendanceTableItem(
    editable: Boolean,
    onFirstClick: () -> Unit
) {
    val modifier = remember(editable) {
        if (editable) Modifier.noIndicationClickable(onClick = onFirstClick) else Modifier
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(dateWeight),
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        Box(
            modifier = Modifier
                .weight(checkboxWeight)
        )
    }
}
