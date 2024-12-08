package com.volsu.unijournal.subject.subject.ui.components.subject_class.lab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.subject.domain.models.LaboratoryState
import com.volsu.unijournal.subject.subject.ui.components.performance.AbsencePerformanceItem
import com.volsu.unijournal.subject.subject.ui.components.performance.EmptyPerformanceItem
import com.volsu.unijournal.subject.subject.ui.components.performance.PerformanceItem

@Composable
internal fun LaboratorySubjectContent(
    state: LaboratoryState,
    modifier: Modifier = Modifier
) {
    val sumItem = remember(state) {
        state.performance.count { !it.second.isEmpty() && !it.second.isAbsence() }
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

        TotalPerformanceItem(
            title = "Всего сдано",
            total = state.total,
            passed = sumItem
        )
    }

}