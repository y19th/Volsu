package com.volsu.unijournal.profile.root.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.local.VolsuSettings
import com.volsu.unijournal.core.util.models.switch
import com.volsu.unijournal.profile.root.ProfileNavigator
import com.volsu.unijournal.profile.root.domain.events.ProfileEvents
import com.volsu.unijournal.profile.root.domain.state.ProfileState

class ProfileComponent(
    componentContext: ComponentContext,
    private val navigator: ProfileNavigator
) : ScreenComponent<ProfileState, ProfileEvents>(
    componentContext = componentContext,
    initialState = ProfileState(currentRole = VolsuSettings.role)
) {
    override fun handleEvent(event: ProfileEvents) {
        when (event) {
            ProfileEvents.OnLogout -> {
                navigate { navigator.logout() }
            }

            ProfileEvents.OnNavigateBack -> {
                navigate { navigator.navigateBackHome() }
            }

            ProfileEvents.OnSwitchRole -> {
                VolsuSettings.role = VolsuSettings.role.switch()
                    .apply { update { it.copy(currentRole = this) } }
            }
        }
    }
}