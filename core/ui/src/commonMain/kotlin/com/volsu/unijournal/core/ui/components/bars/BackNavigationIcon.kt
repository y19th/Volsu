package com.volsu.unijournal.core.ui.components.bars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EditOff
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun BackNavigationIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Icon(
        modifier = Modifier
            .minimumInteractiveComponentSize()
            .clip(CircleShape)
            .semantics { role = Role.Button }
            .clickable { onClick.invoke() }
            .padding(all = 4.dp)
            .then(modifier),
        imageVector = Icons.Default.ArrowBackIosNew,
        contentDescription = "BackButton"
    )
}

@Composable
fun EditableIcon(
    modifier: Modifier = Modifier,
    editableNow: Boolean,
    onClick: () -> Unit
) {
    val state = rememberUpdatedState(editableNow)

    Icon(
        modifier = Modifier
            .minimumInteractiveComponentSize()
            .clip(CircleShape)
            .semantics { role = Role.Button }
            .clickable { onClick.invoke() }
            .padding(all = 4.dp)
            .then(modifier),
        imageVector = if (!state.value) Icons.Default.Edit else Icons.Default.EditOff,
        contentDescription = "Settings icon"
    )
}

@Composable
fun SettingsIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Icon(
        modifier = Modifier
            .minimumInteractiveComponentSize()
            .clip(CircleShape)
            .semantics { role = Role.Button }
            .clickable { onClick.invoke() }
            .padding(all = 4.dp)
            .then(modifier),
        imageVector = Icons.Default.Settings,
        contentDescription = "Settings icon"
    )
}
