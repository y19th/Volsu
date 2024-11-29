package com.volsu.unijournal.home.subject.ui.components.subject_class.lecture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.home.extension.colorByGrade
import com.volsu.unijournal.home.subject.domain.models.LectureState
import com.volsu.unijournal.home.subject.ui.components.performance.AbsencePerformanceItem
import com.volsu.unijournal.home.subject.ui.components.performance.EmptyPerformanceItem
import com.volsu.unijournal.home.subject.ui.components.performance.PerformanceItem
import com.volsu.unijournal.home.subject.ui.components.performance.PerformanceLimitTable

@Composable
internal fun LectureSubjectContent(
    state: LectureState,
    modifier: Modifier = Modifier
) {
    val sumItem = remember(state) {
        "Всего" to state.performance
            .filter { !it.second.isEmpty() && !it.second.isAbsence() }
            .sumOf { it.second.points }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        state.performance.forEach { item ->
            if (item.second.isAbsence())
                AbsencePerformanceItem(
                    item = item.first to "н"
                )
            else if (item.second.isEmpty())
                EmptyPerformanceItem(
                    date = item.first
                )
            else
                PerformanceItem(item)
        }

        PerformanceItem(
            item = sumItem,
            gradeTextColor = sumItem.colorByGrade(),
            withDivider = false
        )
    }

    VerticalSpacer(height = 24.dp)

    PerformanceLimitTable()
}

