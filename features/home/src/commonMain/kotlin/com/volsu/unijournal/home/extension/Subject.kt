package com.volsu.unijournal.home.extension

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Science
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import org.jetbrains.compose.resources.stringResource
import volsu.features.home.generated.resources.Res
import volsu.features.home.generated.resources.group_laboratory_title
import volsu.features.home.generated.resources.group_lecture_title
import volsu.features.home.generated.resources.group_seminar_title


@Composable
internal fun rememberSubjectFormText(form: SubjectForm): String {
    val text = when (form) {
        SubjectForm.Laboratory -> stringResource(Res.string.group_laboratory_title)
        SubjectForm.Lecture -> stringResource(Res.string.group_lecture_title)
        SubjectForm.Seminar -> stringResource(Res.string.group_seminar_title)
    }
    return remember(form) { text }
}

@Composable
internal fun rememberSubjectFormIcon(form: SubjectForm): ImageVector {
    return remember(form) {
        when (form) {
            SubjectForm.Laboratory -> Icons.Filled.Science
            SubjectForm.Lecture -> Icons.Filled.People
            SubjectForm.Seminar -> Icons.Filled.Edit
        }
    }
}

@Composable
internal fun Pair<String, Int>.colorByGrade(): Color {
    val color = if (second < 60)
        volsuColorPalette.badGradeColor else volsuColorPalette.goodGradeColor

    return remember(this) { color }
}