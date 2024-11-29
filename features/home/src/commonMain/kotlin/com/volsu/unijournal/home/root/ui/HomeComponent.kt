package com.volsu.unijournal.home.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.base_components.BaseComponent
import com.volsu.unijournal.core.util.extension.getComponent
import com.volsu.unijournal.home.group.ui.GroupComponent
import com.volsu.unijournal.home.main.ui.MainComponent
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.subject.ui.SubjectComponent
import kotlinx.serialization.Serializable

class HomeComponent(
    componentContext: ComponentContext,
    navigator: HomeNavigator
) : BaseComponent(componentContext) {


    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.MainConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        Configuration.MainConfiguration -> {
            Child.MainChild(getComponent(componentContext))
        }

        is Configuration.GroupConfiguration -> {
            Child.GroupChild(
                getComponent(
                    context = componentContext,
                    param = configuration.group
                )
            )
        }

        is Configuration.SubjectConfiguration -> {
            Child.SubjectChild(
                getComponent(
                    context = componentContext,
                    params = arrayOf(configuration.subject, configuration.subjectType)
                )
            )
        }
    }


    sealed class Child {

        internal data class MainChild(val component: MainComponent) : Child()

        internal data class GroupChild(val component: GroupComponent) : Child()

        internal data class SubjectChild(val component: SubjectComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object MainConfiguration : Configuration()

        @Serializable
        data class GroupConfiguration(
            val group: String
        ) : Configuration()

        @Serializable
        data class SubjectConfiguration(
            val subject: String,
            val subjectType: SubjectType
        ) : Configuration()
    }
}