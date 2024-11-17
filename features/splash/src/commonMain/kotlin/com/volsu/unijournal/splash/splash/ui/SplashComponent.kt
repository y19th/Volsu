package com.volsu.unijournal.splash.splash.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.models.Transition.None
import com.volsu.unijournal.splash.splash.SplashNavigator
import com.volsu.unijournal.splash.splash.domain.events.SplashEvents
import com.volsu.unijournal.splash.splash.domain.state.SplashState

class SplashComponent(
    componentContext: ComponentContext,
    private val navigator: SplashNavigator,
    private val receiveTransition: ReceiveTransitionUseCase
) : ScreenComponent<SplashState, SplashEvents>(
    initialState = SplashState(),
    componentContext = componentContext
) {
    init {
        launchIO {
            launchIO {
                update { it.copy(transition = receiveTransition()) }
            }
        }
    }

    override fun handleEvent(event: SplashEvents) {
        when (event) {
            SplashEvents.OnNavigate -> {
                navigate {
                    navigator.proceed(state.value.transition ?: None)
                }
            }
        }
    }
}