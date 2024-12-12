package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.inputs.DatePickerField
import com.volsu.unijournal.core.util.models.VolsuDate

@Composable
internal fun AttendanceTableCell(
    value: VolsuDate,
    modifier: Modifier = Modifier,
    editable: Boolean = true,
    onValueChange: (Long) -> Unit,
) {
    val state = rememberUpdatedState(value)

    DatePickerField(
        modifier = modifier
            .padding(vertical = 8.dp),
        initialDate = state.value,
        onDateChanged = onValueChange,
        enabled = editable
    )
}