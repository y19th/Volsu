package com.volsu.unijournal.subject.subject.ui.components.role_subject.teacher

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

@Composable
internal fun TeacherSubjectContent() {
    TeacherItem(
        text = "Посещение",
        onClick = {

        }
    )

    VerticalSpacer(height = 8.dp)

    TeacherItem(
        text = "Сданные лабораторные работы",
        onClick = {

        }
    )
}

@Composable
internal fun TeacherItem(
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