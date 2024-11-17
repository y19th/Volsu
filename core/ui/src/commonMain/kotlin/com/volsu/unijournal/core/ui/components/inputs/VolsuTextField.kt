package com.volsu.unijournal.core.ui.components.inputs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextRegular
import com.volsu.unijournal.core.ui.theme.VolsuFontFamily
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.shaped

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolsuTextField(
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
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: ImageVector? = null
) {
    val state = rememberUpdatedState(value)
    val decoratedPlaceholder = decoratedPlaceholderText(placeholder)
    val decoratedLeadingIcon = decoratedLeadingIcon(leadingIcon)

    val focusRequester = remember { FocusRequester() }
    var focused by remember {
        mutableStateOf(false)
    }
    val focusColor by animateColorAsState(
        targetValue = chooseBorderColor(error = error, focused = focused),
        label = "borderColor",
        animationSpec = spring()
    )

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (!readOnly)
                    focused = it.isFocused
            },
        value = state.value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        textStyle = OutlinedTextFieldDefaults.defaultTextStyle(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    ) { inner ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = state.value,
            innerTextField = inner,
            enabled = enabled,
            singleLine = singleLine,
            isError = error,
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            colors = OutlinedTextFieldDefaults.defaultColors(),
            leadingIcon = decoratedLeadingIcon,
            container = {
                Box(
                    modifier = Modifier
                        .shaped(
                            backgroundColor = MaterialTheme.colorScheme.onPrimary,
                            borderColor = focusColor,
                            borderWidth = 0.5.dp
                        )
                )
            },
            placeholder = decoratedPlaceholder
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordVolsuTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    error: Boolean = false,
    readOnly: Boolean = false,
    interactionSource: InteractionSource = remember { MutableInteractionSource() },
    placeholder: String = "",
    leadingIcon: ImageVector? = null
) {
    val state = rememberUpdatedState(value)
    val decoratedPlaceholder = decoratedPlaceholderText(placeholder)
    val decoratedLeadingIcon = decoratedLeadingIcon(leadingIcon)


    val isHidden = rememberSaveable { mutableStateOf(true) }
    val transformation = remember(isHidden.value) {
        if (isHidden.value)
            PasswordVisualTransformation()
        else
            VisualTransformation.None
    }

    val focusRequester = remember { FocusRequester() }
    var focused by remember {
        mutableStateOf(false)
    }
    val focusColor by animateColorAsState(
        targetValue = chooseBorderColor(error = error, focused = focused),
        label = "borderColor",
        animationSpec = spring()
    )

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (!readOnly)
                    focused = it.isFocused
            },
        value = state.value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        visualTransformation = transformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = OutlinedTextFieldDefaults.defaultTextStyle()
    ) { inner ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = state.value,
            innerTextField = inner,
            enabled = enabled,
            singleLine = singleLine,
            isError = error,
            interactionSource = interactionSource,
            visualTransformation = transformation,
            colors = OutlinedTextFieldDefaults.defaultColors(),
            leadingIcon = decoratedLeadingIcon,
            container = {
                Box(
                    modifier = Modifier
                        .shaped(
                            backgroundColor = MaterialTheme.colorScheme.onPrimary,
                            borderColor = focusColor,
                            borderWidth = 0.5.dp
                        )
                )
            },
            placeholder = decoratedPlaceholder,
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { isHidden.value = !isHidden.value }
                        .padding(all = 2.dp),
                    imageVector = if (isHidden.value)
                        Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "visibility icon"
                )
            }
        )
    }
}

@Composable
internal fun chooseBorderColor(focused: Boolean, error: Boolean): Color {
    return with(MaterialTheme.colorScheme) {
        if (error)
            this.error
        else if (focused)
            onSurface
        else outlineVariant
    }

}

@Composable
internal fun OutlinedTextFieldDefaults.defaultColors(): TextFieldColors {
    return colors(
        unfocusedPlaceholderColor = volsuColorPalette.placeholderTextColor,
        focusedPlaceholderColor = volsuColorPalette.placeholderTextColor,
        unfocusedTrailingIconColor = volsuColorPalette.placeholderTextColor,
        focusedTrailingIconColor = volsuColorPalette.placeholderTextColor
    )
}

@Composable
internal fun OutlinedTextFieldDefaults.defaultTextStyle(
    fontSize: TextUnit = 14.sp
) = TextStyle(
    color = volsuColorPalette.primaryTextColor,
    fontWeight = FontWeight.Normal,
    fontSize = fontSize,
    fontFamily = VolsuFontFamily()
)

@Composable
internal fun decoratedPlaceholderText(
    text: String,
    fontSize: TextUnit = 14.sp
): (@Composable () -> Unit)? =
    if (text.isNotEmpty())
        @Composable {
            {
                TextRegular(
                    text = text,
                    fontSize = fontSize,
                    color = volsuColorPalette.placeholderTextColor
                )
            }
        } else null

@Composable
internal fun decoratedLeadingIcon(
    vector: ImageVector?,
): (@Composable () -> Unit)? =
    if (vector != null)
        @Composable {
            {
                Icon(
                    imageVector = vector,
                    contentDescription = null
                )
            }
        } else null