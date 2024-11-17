package com.volsu.unijournal.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextBold
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import volsu.core.ui.generated.resources.Res
import volsu.core.ui.generated.resources.app_name
import volsu.core.ui.generated.resources.icon_volsu_logo

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    val colors = rememberAppLogoColors()

    Image(
        modifier = Modifier
            .size(192.dp)
            .background(
                color = colors.imageBackground,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(all = 24.dp)
            .then(modifier),
        imageVector = vectorResource(Res.drawable.icon_volsu_logo),
        contentDescription = "logo"
    )

    VerticalSpacer(height = 16.dp)

    TextBold(
        text = stringResource(Res.string.app_name),
        fontSize = 32.sp,
        color = colors.titleColor
    )
}

@Composable
private fun rememberAppLogoColors(): AppLogoColors {
    val dark = isSystemInDarkTheme()

    return remember(dark) {
        if(dark)
            /*TODO*/
            AppLogoColors(
                imageBackground = Color(0xFFFFFFFF),
                titleColor = Color(0xFF171717)
            )
        else
            AppLogoColors(
                imageBackground = Color(0xFFFFFFFF),
                titleColor = Color(0xFF171717)
            )
    }
}

private data class AppLogoColors(
    val imageBackground: Color,
    val titleColor: Color
)
