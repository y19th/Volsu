package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier

@Composable
internal fun AttendanceCheckbox(
    initialValue: Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (Boolean) -> Unit
) {
    val state = rememberUpdatedState(initialValue)

    Checkbox(
        modifier = modifier,
        checked = state.value,
        onCheckedChange = onValueChange,
    )
}