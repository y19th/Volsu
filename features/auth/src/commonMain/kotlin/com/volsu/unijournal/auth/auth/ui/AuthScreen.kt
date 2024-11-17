package com.volsu.unijournal.auth.auth.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.auth.auth.domain.events.AuthEvents
import com.volsu.unijournal.auth.auth.ui.components.LoginExpandedContent
import com.volsu.unijournal.core.ui.components.AppLogo
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.buttons.RoundedButton
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import org.jetbrains.compose.resources.stringResource
import volsu.features.auth.generated.resources.Res
import volsu.features.auth.generated.resources.login_login_button


@Composable
fun AuthScreen(
    component: AuthComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()

    VolsuColumn(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        AppLogo()

        LoginExpandedContent(
            uncollectedState = state,
            handleEvents = handleEvents
        )

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            title = stringResource(Res.string.login_login_button),
            isLoading = state.value.isLoading,
            onClick = { handleEvents(AuthEvents.OnAuth) }
        )

        Spacer(modifier = Modifier.weight(0.1f))
    }
}