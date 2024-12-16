package com.volsu.unijournal.subject.detail.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.subject.detail.domain.events.DetailEvents
import com.volsu.unijournal.subject.detail.domain.state.DetailState
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType
import com.volsu.unijournal.subject.root.ui.RootSubjectComponent

internal class DetailSubjectComponent(
    componentContext: ComponentContext,
    type: DetailSubjectType,
    private val subjectType: SubjectType,
    private val navigator: SubjectNavigator
) : ScreenComponent<DetailState, DetailEvents>(
    initialState = DetailState(type),
    componentContext = componentContext
) {
    override fun handleEvent(event: DetailEvents) {
        when (event) {
            DetailEvents.OnNavigateBack -> {
                navigate { navigator.pop() }
            }

            is DetailEvents.OnNavigateToUserAttendance -> {
                navigate {
                    navigator.handleConfiguration(
                        RootSubjectComponent.Configuration.AttendanceDetailConfiguration(
                            event.user
                        )
                    )
                }
            }

            is DetailEvents.OnNavigateToUserPerformance -> {
                navigate {
                    navigator.handleConfiguration(
                        RootSubjectComponent.Configuration.PerformanceDetailConfiguration(
                            user = event.user,
                        )
                    )
                }
            }
        }
    }
}