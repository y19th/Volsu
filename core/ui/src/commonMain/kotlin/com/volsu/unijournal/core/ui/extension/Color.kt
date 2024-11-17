package com.volsu.unijournal.core.ui.extension

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.volsu.unijournal.core.ui.theme.volsuColorPalette

@Composable
fun ButtonDefaults.defaultColors(
    containerColor: Color = volsuColorPalette.primaryColor,
    contentColor: Color = volsuColorPalette.onPrimaryColor
) = buttonColors(
    containerColor = containerColor,
    contentColor = contentColor
)

@Composable
fun ButtonDefaults.textButtonDefaults() = textButtonColors(
    contentColor = volsuColorPalette.primaryColor
)