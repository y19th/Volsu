package com.volsu.unijournal.subject.performance_detail.ui.components.subject_lecture

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
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailLecture
import com.volsu.unijournal.subject.performance_detail.ui.components.DefaultTableItem

@Composable
internal fun EditableSubjectDetailLecture(
    initialState: List<DetailLecture>,
    modifier: Modifier = Modifier,
    onLectureChange: (DetailLecture) -> Unit,
    onAddLecture: () -> Unit
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
        state.value.forEach { lecture ->
            DefaultTableItem(
                subject = lecture,
                onEditSubject = {
                    onLectureChange(it as DetailLecture)
                }
            )
        }
    }
}