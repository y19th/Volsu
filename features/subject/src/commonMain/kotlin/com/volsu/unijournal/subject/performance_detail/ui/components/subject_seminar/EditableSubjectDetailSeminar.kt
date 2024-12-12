package com.volsu.unijournal.subject.performance_detail.ui.components.subject_seminar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailSeminar
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultEmptyTableItem
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultTableItem
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultTableStickyHeader

@Composable
internal fun EditableSubjectDetailSeminar(
    initialState: List<DetailSeminar>,
    editableMode: Boolean,
    modifier: Modifier = Modifier,
    onSeminarChange: (DetailSeminar) -> Unit,
    onAddSeminar: () -> Unit
) {
    val state = rememberUpdatedState(initialState)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(vertical = 16.dp, horizontal = 12.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        DefaultTableStickyHeader(DetailSeminar.empty)

        state.value.forEach { seminar ->
            DefaultTableItem(
                subject = seminar,
                editable = editableMode,
                onEditSubject = {
                    onSeminarChange(it as DetailSeminar)
                }
            )
        }

        DefaultEmptyTableItem(
            editable = editableMode,
            onFirstClick = onAddSeminar
        )
    }
}