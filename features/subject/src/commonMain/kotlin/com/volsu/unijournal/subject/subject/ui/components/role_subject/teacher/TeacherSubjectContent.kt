package com.volsu.unijournal.subject.subject.ui.components.role_subject.teacher

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.extension.rememberSubjectFormPerformanceText
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType.Attendance
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType.Performance
import com.volsu.unijournal.subject.subject.domain.events.SubjectEvents

@Composable
internal fun TeacherSubjectContent(
    subjectForm: SubjectForm,
    handleEvents: (SubjectEvents) -> Unit
) {
    TeacherItem(
        text = "Посещение",
        onClick = {
            handleEvents(SubjectEvents.OnNavigateToDetail(Attendance))
        }
    )

    VerticalSpacer(height = 8.dp)

    TeacherItem(
        text = rememberSubjectFormPerformanceText(subjectForm),
        onClick = {
            handleEvents(SubjectEvents.OnNavigateToDetail(Performance(subjectForm)))
        }
    )
}

@Composable
private fun TeacherItem(
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
}