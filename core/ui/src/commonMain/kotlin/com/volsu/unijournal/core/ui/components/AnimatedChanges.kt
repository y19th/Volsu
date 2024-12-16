package com.volsu.unijournal.core.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.buttons.RoundedButton
import com.volsu.unijournal.core.ui.components.buttons.VolsuTextButton

@Composable
fun ColumnScope.AnimatedChanges(
    visible: Boolean,
    modifier: Modifier = Modifier,
    onDiscard: () -> Unit,
    onCommit: () -> Unit
) {
    val state = rememberUpdatedState(visible)

    AnimatedVisibility(
        modifier = modifier,
        visible = state.value
    ) {
        Column {
            VerticalSpacer(height = 16.dp)

            RoundedButton(
                title = "Сохранить изменения",
                onClick = onCommit
            )

            VerticalSpacer(height = 4.dp)

            VolsuTextButton(
                title = "Отмена",
                onClick = onDiscard
            )
        }

    }

}