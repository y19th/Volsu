package com.volsu.unijournal.subject.subject.ui.components.subject_class.lab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
fun TotalPerformanceItem(
    title: String,
    total: Int,
    passed: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextMedium(
            text = title,
            fontSize = 16.sp,
            color = volsuColorPalette.primaryTextColor
        )

        TextMedium(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = rememberPassedNumberColor(passed, total))) {
                    append(passed.toString())
                }
                append('/')
                append(total.toString())
            },
            fontSize = 16.sp
        )
    }
}

@Composable
fun rememberPassedNumberColor(number: Int, total: Int): Color {
    val color = if (number != total)
        volsuColorPalette.badGradeColor else volsuColorPalette.goodGradeColor
    return remember(number) { color }
}