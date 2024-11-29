package com.volsu.unijournal.home.group.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.domain.models.Subject
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped
import org.jetbrains.compose.resources.stringResource
import volsu.features.home.generated.resources.Res
import volsu.features.home.generated.resources.group_laboratory_title
import volsu.features.home.generated.resources.group_lecture_title
import volsu.features.home.generated.resources.group_seminar_title

@Composable
internal fun SubjectContent(
    item: Subject,
    onClick: () -> Unit,
) {
    val icon = rememberSubjectFormIcon(item.type)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = volsuColorPalette.primaryColor
            )
            Column {
                TextRegular(
                    text = item.name,
                    fontSize = 16.sp,
                    color = volsuColorPalette.primaryTextColor
                )

                VerticalSpacer(height = 2.dp)

                TextRegular(
                    text = rememberSubjectFormText(item.type),
                    fontSize = 12.sp,
                    color = volsuColorPalette.secondaryTextColor
                )
            }
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = volsuColorPalette.primaryColor
        )
    }
}

@Composable
private fun rememberSubjectFormText(form: SubjectForm): String {
    val text = when (form) {
        SubjectForm.Laboratory -> stringResource(Res.string.group_laboratory_title)
        SubjectForm.Lecture -> stringResource(Res.string.group_lecture_title)
        SubjectForm.Seminar -> stringResource(Res.string.group_seminar_title)
    }
    return remember(form) { text }
}

@Composable
private fun rememberSubjectFormIcon(form: SubjectForm): ImageVector {
    return remember(form) {
        when (form) {
            SubjectForm.Laboratory -> Icons.Filled.Science
            SubjectForm.Lecture -> Icons.Filled.People
            SubjectForm.Seminar -> Icons.Filled.Edit
        }
    }
}