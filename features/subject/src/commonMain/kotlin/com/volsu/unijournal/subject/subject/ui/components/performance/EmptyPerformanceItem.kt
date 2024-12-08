package com.volsu.unijournal.subject.subject.ui.components.performance

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
internal fun EmptyPerformanceItem(
    date: String,
    withDivider: Boolean = true,
) {
    TextMedium(
        modifier = Modifier
            .fillMaxWidth(),
        text = date,
        fontSize = 16.sp,
        color = volsuColorPalette.primaryTextColor
    )

    if (withDivider)
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 4.dp)
        )
}