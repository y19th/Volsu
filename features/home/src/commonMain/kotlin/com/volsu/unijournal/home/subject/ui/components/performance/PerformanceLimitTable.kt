package com.volsu.unijournal.home.subject.ui.components.performance

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
import org.jetbrains.compose.resources.stringArrayResource
import volsu.features.home.generated.resources.Res
import volsu.features.home.generated.resources.performance_grades
import volsu.features.home.generated.resources.performance_table

@Composable
internal fun PerformanceLimitTable() {
    val table = rememberBorderTable()

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
       table.forEach { item ->
           PerformanceItem(
               item = item,
               withDivider = table.last() != item
           )
       }
    }
}

@Composable
private fun rememberBorderTable(): List<Pair<String, String>> {
    val performanceTable = stringArrayResource(Res.array.performance_table)
    val gradeTable = stringArrayResource(Res.array.performance_grades)

    return remember { performanceTable.zip(gradeTable) }
}