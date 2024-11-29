package com.volsu.unijournal.home.subject.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.mapper.toSubjectForm
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.subject.domain.events.SubjectEvents
import com.volsu.unijournal.home.subject.domain.state.SubjectState

internal class SubjectComponent(
    componentContext: ComponentContext,
    subject: String,
    type: SubjectType,
    private val navigator: HomeNavigator
) : ScreenComponent<SubjectState, SubjectEvents>(
    initialState = SubjectState(
        subject = subject,
        form = type.toSubjectForm()
    ),
    componentContext = componentContext
) {
    override fun handleEvent(event: SubjectEvents) {
        when (event) {
            SubjectEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }
        }
    }
}