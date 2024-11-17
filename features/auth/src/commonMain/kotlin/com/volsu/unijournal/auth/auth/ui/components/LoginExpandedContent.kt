package com.volsu.unijournal.auth.auth.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.auth.auth.domain.events.AuthEvents
import com.volsu.unijournal.auth.auth.domain.state.AuthState
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.inputs.PasswordVolsuTextField
import com.volsu.unijournal.core.ui.components.inputs.VolsuTextField
import org.jetbrains.compose.resources.stringResource
import volsu.features.auth.generated.resources.Res
import volsu.features.auth.generated.resources.login_login_placeholder
import volsu.features.auth.generated.resources.login_password_placeholder

@Composable
internal fun LoginExpandedContent(
    uncollectedState: State<AuthState>,
    handleEvents: (AuthEvents) -> Unit
) {
    val state = uncollectedState.value

    Column {

        VerticalSpacer(height = 36.dp)

        VolsuTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.email,
            leadingIcon = Icons.Default.Email,
            placeholder = stringResource(Res.string.login_login_placeholder),
            keyboardType = KeyboardType.Email,
            error = state.isEmailError,
            onValueChange = {
                handleEvents(AuthEvents.OnEmailChanged(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        PasswordVolsuTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.password,
            leadingIcon = Icons.Default.Password,
            placeholder = stringResource(Res.string.login_password_placeholder),
            error = state.isPasswordError,
            onValueChange = {
                handleEvents(AuthEvents.OnPasswordChanged(it))
            }
        )
    }

}