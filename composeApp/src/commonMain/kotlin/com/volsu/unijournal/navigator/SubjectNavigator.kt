package com.volsu.unijournal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.subject.root.SubjectNavigator
import com.volsu.unijournal.subject.root.ui.RootSubjectComponent

internal class SubjectNavigatorImpl(
    private val homeNavigator: HomeNavigator
) : SubjectNavigator {
    override val navigation: StackNavigation<RootSubjectComponent.Configuration> = StackNavigation()

    override fun navigateBack() {
        homeNavigator.pop()
    }

    override fun handleConfiguration(configuration: RootSubjectComponent.Configuration) {
        navigation.bringToFront(configuration)
    }
}