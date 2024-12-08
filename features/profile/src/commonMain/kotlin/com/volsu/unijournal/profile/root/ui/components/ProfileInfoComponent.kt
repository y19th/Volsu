package com.volsu.unijournal.profile.root.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.models.Role

@Composable
internal fun ProfileInfoComponent(
    currentRole: Role
) {
    ProfileItem(
        text = "Агапченко Олег",
        title = "Имя"
    )

    VerticalSpacer(height = 8.dp)

    ProfileItem(
        text = currentRole.value,
        title = "Роль"
    )
}

@Composable
internal fun ProfileItem(
    title: String,
    text: String
) {
    TextRegular(
        text = title,
        fontSize = 16.sp,
        color = volsuColorPalette.secondaryTextColor
    )

    VerticalSpacer(height = 4.dp)

    TextSemibold(
        text = text,
        fontSize = 20.sp,
        color = volsuColorPalette.primaryTextColor
    )
}