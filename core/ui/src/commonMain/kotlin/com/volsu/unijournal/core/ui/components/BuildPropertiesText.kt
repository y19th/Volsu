package com.volsu.unijournal.core.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.local.VolsuSettings
import com.volsu.unijournal.core.util.models.versionName

@Composable
fun BuildPropertiesText(
    modifier: Modifier = Modifier,
    color: Color = volsuColorPalette.tertiaryTextColor,
    style: TextStyle = MaterialTheme.typography.displaySmall
) {
    val versionName = rememberSaveable {
        VolsuSettings.properties.versionName()
    }

    Text(
        modifier = modifier,
        text = versionName,
        style = style,
        color = color
    )

}