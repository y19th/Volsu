package com.volsu.unijournal.subject.attendance_detail.ui.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier

@Composable
internal fun AttendanceTableCell(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val state = rememberUpdatedState(value)

    BasicTextField(
        modifier = modifier,
        value = state.value,
        onValueChange = onValueChange
    )
}