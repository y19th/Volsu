package com.volsu.unijournal.subject.performance_detail.ui.components.subject_laboratory

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLaboratory
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultEmptyTableItem
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultTableItem
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultTableStickyHeader

@Composable
internal fun EditableSubjectDetailLaboratory(
    initialState: List<DetailLaboratory>,
    editableMode: Boolean,
    modifier: Modifier = Modifier,
    onLectureChange: (DetailLaboratory) -> Unit,
    onAddLecture: () -> Unit
) {
    val state = rememberUpdatedState(initialState)
    val passedLaboratories = remember(state.value) {
        derivedStateOf { state.value.count { it.performance != DetailState.placeholder } }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(vertical = 16.dp, horizontal = 12.dp)
            .animateContentSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        DefaultTableStickyHeader(DetailLaboratory.empty)

        state.value.forEach { lecture ->
            DefaultTableItem(
                subject = lecture,
                editable = editableMode,
                onEditSubject = {
                    onLectureChange(it as DetailLaboratory)
                }
            )
        }

        DefaultEmptyTableItem(
            editable = editableMode,
            onFirstClick = onAddLecture
        )
    }

    VerticalSpacer(height = 12.dp)

    DetailLaboratoryCount(
        passed = passedLaboratories.value,
        laboratoryCount = state.value.size
    )
}