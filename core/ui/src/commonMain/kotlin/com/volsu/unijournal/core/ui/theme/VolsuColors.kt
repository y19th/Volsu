package com.volsu.unijournal.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val volsuColorPalette: VolsuColors
    @Composable
    get() = LocalVolsuColors.current

val LocalVolsuColors = staticCompositionLocalOf { volsuColorPalette() }

data class VolsuColors(
    val primaryColor: Color,
    val onPrimaryColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val tertiaryTextColor: Color,
    val placeholderTextColor: Color,
    val homePrimaryColor: Color,
    val homeSecondaryTextColor: Color,
    val outlineColor: Color,
    val onOutlineColor: Color,
    val hintColor: Color,
    val shimColor: Color,
    val profileSecondaryColor: Color,
    val badGradeColor: Color,
    val goodGradeColor: Color
)

private fun volsuColorPalette(): VolsuColors = VolsuColors(
    primaryColor = PrimaryColor,
    onPrimaryColor = OnPrimaryColor,
    primaryTextColor = PrimaryTextColor,
    secondaryTextColor = SecondaryTextColor,
    tertiaryTextColor = TertiaryTextColor,
    placeholderTextColor = PlaceholderTextColor,
    homePrimaryColor = HomePrimaryColor,
    homeSecondaryTextColor = HomeSecondaryTextColor,
    outlineColor = OutlineColor,
    onOutlineColor = OnOutlineColor,
    hintColor = HintColor,
    shimColor = ShimColor,
    profileSecondaryColor = ProfileSecondaryTextColor,
    badGradeColor = BadGradeColor,
    goodGradeColor = GoodGradeColor
)