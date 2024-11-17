package com.volsu.unijournal.home.group.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.home.group.domain.events.GroupEvents
import com.volsu.unijournal.home.group.domain.state.GroupState
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.root.ui.HomeComponent

internal class GroupComponent(
    componentContext: ComponentContext,
    model: String,
    private val navigator: HomeNavigator
) : ScreenComponent<GroupState, GroupEvents>(
    initialState = GroupState(model),
    componentContext = componentContext
) {
    override fun handleEvent(event: GroupEvents) {
        when (event) {
            GroupEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            GroupEvents.OnNavigateToSettings -> {

            }

            is GroupEvents.OnNavigateToSubject -> {
                navigate {
                    navigator.handleConfiguration(
                        HomeComponent.Configuration.SubjectConfiguration(
                            subject = event.subject
                        )
                    )
                }
            }
        }
    }
}