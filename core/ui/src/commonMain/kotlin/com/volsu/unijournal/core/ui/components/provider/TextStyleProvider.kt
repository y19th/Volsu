package com.volsu.unijournal.core.ui.components.provider

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun fieldTextStyle(): TextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium
)

@Composable
fun ProvideFieldTextStyle(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        value = LocalTextStyle provides fieldTextStyle(),
        content = content
    )
}