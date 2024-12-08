package com.volsu.unijournal.subject.subject.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.subject.extension.rememberSubjectFormText

@Composable
internal fun SubjectTitle(
    subjectName: String,
    subjectForm: SubjectForm
) {
    TextSemibold(
        modifier = Modifier
            .fillMaxWidth(0.85f),
        text = subjectName,
        fontSize = 26.sp,
        lineHeight = 30.sp,
        color = volsuColorPalette.primaryTextColor
    )

    VerticalSpacer(height = 6.dp)

    TextRegular(
        text = rememberSubjectFormText(subjectForm),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = volsuColorPalette.secondaryTextColor
    )
}