package com.volsu.unijournal.home.group.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.mapper.asConfig
import com.volsu.unijournal.core.domain.mapper.asGroupModel
import com.volsu.unijournal.core.domain.mapper.toSubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.GroupConfig
import com.volsu.unijournal.home.group.domain.events.GroupEvents
import com.volsu.unijournal.home.group.domain.state.GroupState
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.root.ui.HomeComponent

internal class GroupComponent(
    componentContext: ComponentContext,
    model: GroupConfig,
    private val navigator: HomeNavigator
) : ScreenComponent<GroupState, GroupEvents>(
    initialState = GroupState(model.asGroupModel()),
    componentContext = componentContext
) {
    override fun handleEvent(event: GroupEvents) {
        when (event) {
            GroupEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            GroupEvents.OnNavigateToSettings -> {
                navigate { navigator.navigateToProfile() }
            }

            is GroupEvents.OnNavigateToSubject -> {
                navigate {
                    navigator.handleConfiguration(
                        HomeComponent.Configuration.SubjectConfiguration(
                            subject = event.subject.name,
                            subjectType = event.subject.type.toSubjectType(),
                            group = state.value.group.asConfig()
                        )
                    )
                }
            }
        }
    }
}