package com.volsu.unijournal.subject.subject.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.mapper.toSubjectForm
import com.volsu.unijournal.core.domain.mapper.toSubjectType
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.root.ui.RootSubjectComponent
import com.volsu.unijournal.subject.subject.domain.events.SubjectEvents
import com.volsu.unijournal.subject.subject.domain.state.SubjectState

internal class SubjectComponent(
    componentContext: ComponentContext,
    subject: String,
    type: SubjectType,
    private val navigator: SubjectNavigator
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
                navigate { navigator.navigateBack() }
            }

            is SubjectEvents.OnNavigateToDetail -> {
                navigate {
                    navigator.handleConfiguration(
                        RootSubjectComponent.Configuration.DetailConfiguration(
                            type = event.type,
                            subjectType = state.value.form.toSubjectType()
                        )
                    )
                }
            }
        }
    }
}