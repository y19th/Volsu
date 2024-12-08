package com.volsu.unijournal.subject.subject.ui.components.performance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
internal fun AbsencePerformanceItem(
    item: Pair<String, String>,
    withDivider: Boolean = true,
    gradeTextColor: Color = volsuColorPalette.badGradeColor
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextMedium(
            text = item.first,
            fontSize = 16.sp,
            color = volsuColorPalette.primaryTextColor
        )

        TextMedium(
            text = item.second,
            fontSize = 16.sp,
            color = gradeTextColor
        )
    }

    if(withDivider)
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 4.dp)
        )
}