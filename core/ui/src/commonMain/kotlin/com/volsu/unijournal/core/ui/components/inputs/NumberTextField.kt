package com.volsu.unijournal.core.ui.components.inputs

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun NumberTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    error: Boolean = false,
    readOnly: Boolean = false,
    interactionSource: InteractionSource = remember { MutableInteractionSource() },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String = "",
    leadingIcon: ImageVector? = null
) {
    VolsuTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        singleLine = singleLine,
        error = error,
        readOnly = readOnly,
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        placeholder = placeholder,
        keyboardType = KeyboardType.Number,
        leadingIcon = leadingIcon
    )
}