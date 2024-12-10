package com.volsu.unijournal.subject.performance_detail.ui.components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.util.extension.toIntOrElse
import com.volsu.unijournal.subject.performance_detail.domain.models.DetailState

@Composable
internal fun DefaultTableItem(
    subject: DetailState,
    onEditSubject: (DetailState) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
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
                value = subject.second(),
                onValueChange = {
                    onEditSubject(subject.copySecond(newSecond = it))
                }
            )
        }

        HorizontalDivider()
    }
}

@Composable
private fun DefaultTableCell(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val state = rememberUpdatedState(value)

    BasicTextField(
        modifier = modifier,
        value = state.value,
        onValueChange = onValueChange
    )
}

@Composable
private fun DefaultNumberTableCell(
    value: Int,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit
) {
    val state = rememberUpdatedState(value)

    BasicTextField(
        modifier = modifier,
        value = state.value.toString(),
        onValueChange = {
            if (it.length <= 2)
                onValueChange(it.toIntOrElse(DetailState.placeholder))
        }
    )
}