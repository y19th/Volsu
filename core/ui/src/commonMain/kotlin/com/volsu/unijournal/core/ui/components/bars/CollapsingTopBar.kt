package com.volsu.unijournal.core.ui.components.bars

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextSemibold


sealed interface CollapseState {

    data class Collapsed(val text: String) : CollapseState

    data class Normal(val text: String) : CollapseState
}

@Composable
fun CollapsingPerformanceDetailTopBar(
    normal: CollapseState.Normal,
    collapsed: CollapseState.Collapsed,
    editableState: Boolean,
    isCollapsed: Boolean = false,
    onClick: () -> Unit
) {
    CollapsingVolsuTopBar(
        isCollapsed = isCollapsed,
        uncollapsedContent = {
            TextSemibold(
                text = normal.text,
                fontSize = 20.sp,
                lineHeight = 32.sp
            )
        },
        collapsedContent = {
            TextSemibold(
                text = collapsed.text,
                fontSize = 20.sp,
                lineHeight = 32.sp
            )
        },
        trailingIcon = {
            EditableIcon(
                editableNow = editableState,
                onClick = onClick
            )
        }
    )
}