package com.volsu.unijournal.subject.detail.ui.components.subject_ui.performance

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.detail.domain.models.DetailSubjectState

@Composable
fun PerformanceUi(
    state: DetailSubjectState.Performance,
    onUserClick: (String) -> Unit
) {
    VerticalSpacer(height = 24.dp)

    state.items.forEach { item ->
        PerformanceItem(
            text = item,
            onClick = {
                onUserClick(item)
            }
        )
    }
}

@Composable
private fun PerformanceItem(
    text: String,
    onClick: () -> Unit
) {
    TextRegular(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 16.dp),
        text = text,
        fontSize = 16.sp,
        color = volsuColorPalette.primaryTextColor
    )

    VerticalSpacer(height = 12.dp)
}