package com.volsu.unijournal.subject.performance_detail.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.provider.fieldTextStyle
import com.volsu.unijournal.core.util.extension.noIndicationClickable
import com.volsu.unijournal.core.util.extension.toIntOrElse
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState

private val boxHeight: Dp
    @Composable
    get() = with(LocalDensity.current) {
        16.dp + 16.sp.toDp()
    }

@Composable
internal fun DefaultTableItem(
    subject: DetailState,
    editable: Boolean,
    onEditSubject: (DetailState) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DefaultTableCell(
            modifier = Modifier
                .weight(0.5f),
            value = subject.first(),
            editable = editable,
            onValueChange = {
                onEditSubject(subject.copyFirst(newFirst = it))
            }
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )

        DefaultNumberTableCell(
            modifier = Modifier
                .weight(0.2f),
            value = subject.secondAsString(),
            onValueChange = {
                onEditSubject(subject.copySecond(newSecond = it))
            }
        )
    }

    HorizontalDivider()
}

@Composable
internal fun DefaultEmptyTableItem(
    editable: Boolean,
    onFirstClick: () -> Unit
) {
    val modifier = remember(editable) {
        if (editable) Modifier.noIndicationClickable(onClick = onFirstClick) else Modifier
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(boxHeight)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.weight(0.5f)
        )

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp)
        )


        Box(
            modifier = Modifier.weight(0.2f)
        )
    }
}

@Composable
private fun DefaultTableCell(
    value: String,
    modifier: Modifier = Modifier,
    editable: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    val state = rememberUpdatedState(value)

    BasicTextField(
        modifier = modifier
            .padding(vertical = 8.dp),
        value = state.value,
        readOnly = editable.not(),
        textStyle = fieldTextStyle(),
        onValueChange = onValueChange
    )
}

@Composable
private fun DefaultNumberTableCell(
    value: String,
    modifier: Modifier = Modifier,
    editable: Boolean = true,
    onValueChange: (Int) -> Unit
) {
    val state = rememberUpdatedState(value)

    BasicTextField(
        modifier = modifier,
        value = state.value,
        readOnly = editable.not(),
        onValueChange = {
            if (it.length <= 2)
                onValueChange(it.toIntOrElse(DetailState.placeholder))
        }
    )
}