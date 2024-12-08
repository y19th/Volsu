package com.volsu.unijournal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.home.root.ui.HomeComponent
import com.volsu.unijournal.root.RootComponent

internal class HomeNavigatorImpl(
    private val rootNavigator: RootNavigator
) : HomeNavigator {
    override val navigation: StackNavigation<HomeComponent.Configuration> = StackNavigation()

    override fun handleConfiguration(configuration: HomeComponent.Configuration) {
        navigation.bringToFront(configuration)
    }

    override fun navigateToProfile() {
        rootNavigator.handleConfiguration(RootComponent.Configuration.ProfileConfiguration)
    }
}