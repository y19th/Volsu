package com.volsu.unijournal.subject.performance_detail.ui.components.subject_laboratory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped
import com.volsu.unijournal.subject.subject.ui.components.subject_class.lab.rememberPassedNumberColor

@Composable
internal fun DetailLaboratoryCount(
    passed: Int,
    laboratoryCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .padding(vertical = 16.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextMedium(
            modifier = Modifier
                .weight(0.8f),
            text = "Всего лабораторных работ",
            fontSize = 16.sp,
            color = volsuColorPalette.primaryTextColor
        )

        Box(
            modifier = Modifier
                .weight(0.2f)
        ) {
            TextMedium(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = rememberPassedNumberColor(passed, laboratoryCount)
                        )
                    ) {
                        append(passed.toString())
                    }
                    append('/')
                    append(laboratoryCount.toString())
                },
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}