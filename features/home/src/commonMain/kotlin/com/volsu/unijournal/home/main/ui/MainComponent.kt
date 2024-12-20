package com.volsu.unijournal.home.main.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.mapper.asConfig
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.local.VolsuSettings
import com.volsu.unijournal.home.main.domain.events.MainEvents
import com.volsu.unijournal.home.main.domain.state.MainState
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.root.ui.HomeComponent

internal class MainComponent(
    componentContext: ComponentContext,
    private val navigator: HomeNavigator,
) : ScreenComponent<MainState, MainEvents>(
    initialState = MainState(),
    componentContext = componentContext
) {

    override fun handleEvent(event: MainEvents) {
        when (event) {
            MainEvents.OnRefresh -> {
                update { it.copy(currentRole = VolsuSettings.role) }
            }

            MainEvents.OnNavigateToProfile -> {
                navigate { navigator.navigateToProfile() }
            }

            is MainEvents.OnNavigateToGroup -> {
                navigate {
                    navigator.handleConfiguration(
                        HomeComponent.Configuration.GroupConfiguration(
                            group = event.group.asConfig()
                        )
                    )
                }
            }
        }
    }
}