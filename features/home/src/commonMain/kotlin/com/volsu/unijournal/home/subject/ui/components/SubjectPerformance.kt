package com.volsu.unijournal.home.subject.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped

@Composable
internal fun SubjectPerformance(
    items: List<Pair<String, Int>>
) {
    val sumItem = remember(items) { "Всего" to items.sumOf { it.second } }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items.forEach { item ->
            PerformanceItem(item)
        }

        PerformanceItem(
            item = sumItem,
            gradeTextColor = sumItem.colorByGrade(),
            withDivider = false
        )
    }
}

@Composable
private fun Pair<String, Int>.colorByGrade(): Color {
    val color = if(second < 60)
        volsuColorPalette.badGradeColor else volsuColorPalette.goodGradeColor

    return remember(this) { color }
}