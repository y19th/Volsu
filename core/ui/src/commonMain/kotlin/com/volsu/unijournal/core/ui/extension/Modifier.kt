package com.volsu.unijournal.core.ui.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
fun Modifier.shim(
    color: Color = volsuColorPalette.shimColor
): Modifier {
    return this
        //.shimmer()
        .background(
            color = color,
            shape = RoundedCornerShape(8.dp)
        )

}