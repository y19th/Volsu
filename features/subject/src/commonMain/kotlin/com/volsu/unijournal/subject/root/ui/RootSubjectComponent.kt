package com.volsu.unijournal.subject.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.BaseComponent
import com.volsu.unijournal.core.util.extension.getComponent
import com.volsu.unijournal.core.util.models.GroupConfig
import com.volsu.unijournal.subject.attendance_detail.ui.AttendanceDetailComponent
import com.volsu.unijournal.subject.detail.ui.DetailSubjectComponent
import com.volsu.unijournal.subject.performance_detail.ui.PerformanceDetailComponent
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.root.domain.models.DetailSubjectType
import com.volsu.unijournal.subject.subject.ui.SubjectComponent
import com.volsu.unijournal.subject.today_attendance.ui.TodayAttendanceComponent
import kotlinx.serialization.Serializable

class RootSubjectComponent(
    componentContext: ComponentContext,
    navigator: SubjectNavigator,
    private val subject: String,
    private val type: SubjectType,
    private val group: GroupConfig
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        initialConfiguration = Configuration.MainConfiguration,
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
                    params = arrayOf(configuration.type, type)
                )
            )
        }

        is Configuration.MainConfiguration -> {
            Child.MainChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(subject, type, group)
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

        is Configuration.PerformanceDetailConfiguration -> {
            Child.PerformanceDetailChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(configuration.user, type)
                )
            )
        }

        is Configuration.TodayAttendanceConfiguration -> {
            Child.TodayAttendanceChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(type, group)
                )
            )
        }
    }

    sealed class Child {

        internal data class MainChild(val component: SubjectComponent) : Child()

        internal data class DetailChild(val component: DetailSubjectComponent) : Child()

        internal data class AttendanceDetailChild(val component: AttendanceDetailComponent) :
            Child()

        internal data class PerformanceDetailChild(val component: PerformanceDetailComponent) :
            Child()

        internal data class TodayAttendanceChild(val component: TodayAttendanceComponent) :
            Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object MainConfiguration : Configuration()

        @Serializable
        data class DetailConfiguration(
            val type: DetailSubjectType
        ) : Configuration()

        @Serializable
        data class AttendanceDetailConfiguration(
            val user: String
        ) : Configuration()

        @Serializable
        data object TodayAttendanceConfiguration : Configuration()

        @Serializable
        data class PerformanceDetailConfiguration(
            val user: String
        ) : Configuration()
    }
}