package com.volsu.unijournal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.volsu.unijournal.profile.root.ProfileNavigator
import com.volsu.unijournal.root.RootComponent

internal class ProfileNavigatorImpl(
    private val rootNavigator: RootNavigator
) : ProfileNavigator {
    override val navigation: StackNavigation<Unit> = StackNavigation()

    override fun logout() {
        rootNavigator.handleConfiguration(RootComponent.Configuration.AuthConfiguration)
    }

    override fun navigateBackHome() {
        rootNavigator.pop()
    }

    override fun handleConfiguration(configuration: Unit) {
        navigation.bringToFront(configuration)
    }
}