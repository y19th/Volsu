package com.volsu.unijournal.profile.root.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.ui.components.buttons.RoundedButton
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.profile.root.domain.events.ProfileEvents
import com.volsu.unijournal.profile.root.ui.components.ProfileInfoComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    component: ProfileComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    VolsuColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp),
        topBar = {
            NavigationTopBar(
                title = "Профиль",
                navigationIcon = {
                    BackNavigationIcon { handleEvents(ProfileEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        ProfileInfoComponent(
            currentRole = state.value.currentRole
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        RoundedButton(
            title = "change role",
            onClick = {
                handleEvents(ProfileEvents.OnSwitchRole)
            }
        )

        VerticalSpacer(height = 16.dp)

        RoundedButton(
            title = "Выйти",
            onClick = {
                handleEvents(ProfileEvents.OnLogout)
            }
        )
    }
}