package com.volsu.unijournal.subject.today_attendance.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
internal fun TodayAttendanceNameCell(
    name: String,
    modifier: Modifier = Modifier
) {
    TextMedium(
        modifier = modifier,
        text = name,
        fontSize = 16.sp,
        color = volsuColorPalette.primaryTextColor
    )
}