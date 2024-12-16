package com.volsu.unijournal.subject.today_attendance.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.today_attendance.domain.models.TodayAttendance

@Composable
internal fun TodayAttendanceTable(
    editable: Boolean,
    attendance: List<TodayAttendance>,
    modifier: Modifier = Modifier,
    onEditAttend: (TodayAttendance) -> Unit
) {
    val state by rememberUpdatedState(attendance)

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
        state.forEachIndexed { index, item ->
            TodayAttendanceItem(
                editable = editable,
                item = item,
                onEditAttend = onEditAttend,
                isLastItem = index == state.lastIndex
            )
        }
    }
}