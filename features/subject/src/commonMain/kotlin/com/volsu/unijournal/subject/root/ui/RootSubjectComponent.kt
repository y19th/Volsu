package com.volsu.unijournal.subject.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.BaseComponent
import com.volsu.unijournal.core.util.extension.getComponent
import com.volsu.unijournal.subject.attendance_detail.ui.AttendanceDetailComponent
import com.volsu.unijournal.subject.detail.ui.DetailSubjectComponent
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType
import com.volsu.unijournal.subject.subject.ui.SubjectComponent
import kotlinx.serialization.Serializable

class RootSubjectComponent(
    componentContext: ComponentContext,
    navigator: SubjectNavigator,
    subject: String,
    type: SubjectType
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        initialConfiguration = Configuration.MainConfiguration(subject, type),
        serializer = Configuration.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        is Configuration.DetailConfiguration -> {
            Child.DetailChild(
                getComponent(
                    context = componentContext,
                    param = configuration.type
                )
            )
        }

        is Configuration.MainConfiguration -> {
            Child.MainChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(configuration.subject, configuration.type)
                )
            )
        }

        is Configuration.AttendanceDetailConfiguration -> {
            Child.AttendanceDetailChild(
                getComponent(
                    context = componentContext,
                    param = configuration.user
                )
            )
        }
    }

    sealed class Child {

        internal data class MainChild(val component: SubjectComponent) : Child()

        internal data class DetailChild(val component: DetailSubjectComponent) : Child()

        internal data class AttendanceDetailChild(val component: AttendanceDetailComponent) :
            Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data class MainConfiguration(
            val subject: String,
            val type: SubjectType,
        ) : Configuration()

        @Serializable
        data class DetailConfiguration(
            val type: DetailSubjectType
        ) : Configuration()

        @Serializable
        data class AttendanceDetailConfiguration(
            val user: String
        ) : Configuration()
    }
}