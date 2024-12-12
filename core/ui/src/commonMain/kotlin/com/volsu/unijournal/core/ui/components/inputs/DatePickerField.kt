package com.volsu.unijournal.core.ui.components.inputs

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.extension.toggle
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.extension.noIndicationClickable
import com.volsu.unijournal.core.util.models.VolsuDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    initialDate: VolsuDate,
    onDateChanged: (Long) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val date = rememberUpdatedState(initialDate)
    val isPickerVisible = rememberSaveable { mutableStateOf(false) }
    val dateState = rememberDatePickerState(
        initialSelectedDateMillis = initialDate.millis
    )

    val internalModifier = remember(enabled) {
        if (enabled) modifier.noIndicationClickable { isPickerVisible.toggle() } else modifier
    }

    TextMedium(
        modifier = internalModifier,
        text = date.value.representAsString(),
        fontSize = 16.sp
    )

    if (isPickerVisible.value)
        DatePickerDialog(
            onDismissRequest = { isPickerVisible.toggle() },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDateChanged(dateState.selectedDateMillis ?: 0L)
                        isPickerVisible.toggle()
                    }
                ) {
                    TextMedium(
                        text = "Готово",
                        fontSize = 16.sp
                    )
                }
            },
            colors = DatePickerDefaults.colors(
                containerColor = volsuColorPalette.onPrimaryColor
            )
        ) {
            DatePicker(
                state = dateState,
                showModeToggle = false,
                colors = DatePickerDefaults.colors(
                    containerColor = volsuColorPalette.onPrimaryColor
                )
            )
        }
}