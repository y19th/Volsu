package com.volsu.unijournal.subject.performance_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.subject.performance_detail.domain.events.PerformanceDetailEvents
import com.volsu.unijournal.subject.performance_detail.domain.state.PerformanceDetailState
import com.volsu.unijournal.subject.root.SubjectNavigator

internal class PerformanceDetailComponent(
    componentContext: ComponentContext,
    user: String,
    type: SubjectType,
    private val navigator: SubjectNavigator
) : ScreenComponent<PerformanceDetailState, PerformanceDetailEvents>(
    initialState = PerformanceDetailState(user, type),
    componentContext = componentContext
) {
    override fun handleEvent(event: PerformanceDetailEvents) {
        when (event) {
            PerformanceDetailEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            PerformanceDetailEvents.OnAddSubject -> {

            }
            is PerformanceDetailEvents.OnSubjectChange -> {

            }
        }
    }
}