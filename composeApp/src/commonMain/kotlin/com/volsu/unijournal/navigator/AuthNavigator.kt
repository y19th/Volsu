package com.volsu.unijournal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.volsu.unijournal.auth.auth.AuthNavigator
import com.volsu.unijournal.root.RootComponent

internal class AuthNavigatorImpl(
    private val rootNavigator: RootNavigator
) : AuthNavigator {

    override val navigation: StackNavigation<Unit> = StackNavigation()

    override fun navigateHome() {
        rootNavigator.handleConfiguration(RootComponent.Configuration.HomeConfiguration)
    }

    override fun handleConfiguration(configuration: Unit) = Unit
}