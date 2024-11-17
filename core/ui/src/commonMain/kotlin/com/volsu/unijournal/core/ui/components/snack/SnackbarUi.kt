package com.volsu.unijournal.core.ui.components.snack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.HorizontalSpacer
import com.volsu.unijournal.core.ui.components.snack.data.VolsuSnackbarData
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun VolsuSnackbar(
    modifier: Modifier = Modifier,
    data: SnackbarData
) {
    data.visuals.let { visuals ->
        if (visuals is VolsuSnackbarData)
            VolsuSnackbarWithCustomData(
                modifier = modifier,
                data = visuals
            )
        else
            VolsuSnackbarWithDefaultData(
                modifier = modifier,
                data = visuals
            )
    }
}

@Composable
internal fun VolsuSnackbarWithDefaultData(
    modifier: Modifier = Modifier,
    data: SnackbarVisuals
) {
    val colors = rememberSnackbarColors()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = colors.background,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextMedium(
            text = data.message,
            fontSize = 14.sp
        )
    }
}


@Composable
internal fun VolsuSnackbarWithCustomData(
    modifier: Modifier = Modifier,
    data: VolsuSnackbarData
) {
    val colors = rememberSnackbarColors()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = colors.background,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp),
            painter = painterResource(data.status.resource),
            contentDescription = "snack_image"
        )

        HorizontalSpacer(width = 8.dp)

        TextMedium(
            text = data.message,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun rememberSnackbarColors(): SnackbarColors {
    val background = if (isSystemInDarkTheme()) Color.DarkGray else Color.White
    val content = LocalContentColor.current

    return remember(content, background) { SnackbarColors(background, content) }
}

private data class SnackbarColors(
    val background: Color,
    val content: Color,
)