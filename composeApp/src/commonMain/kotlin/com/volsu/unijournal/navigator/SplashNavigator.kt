package com.volsu.unijournal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.volsu.unijournal.core.util.models.Transition
import com.volsu.unijournal.root.RootComponent
import com.volsu.unijournal.splash.splash.SplashNavigator

internal class SplashNavigatorImpl(
    private val rootNavigator: RootNavigator
) : SplashNavigator {

    override val navigation: StackNavigation<Unit> = StackNavigation()

    override fun handleConfiguration(configuration: Unit) = Unit

    override fun proceed(transition: Transition) {
        when(transition) {
            Transition.Authorized -> {
                //TODO()
            }
            Transition.None -> {
                rootNavigator.handleConfiguration(
                    RootComponent.Configuration.AuthConfiguration
                )
            }
        }
    }
}