package com.volsu.unijournal.auth.auth.ui

import com.arkivanov.decompose.ComponentContext
import com.volsu.unijournal.core.domain.use_cases.transition.UpdateTransitionUseCase
import com.volsu.unijournal.auth.auth.AuthNavigator
import com.volsu.unijournal.auth.auth.domain.events.AuthEvents
import com.volsu.unijournal.auth.auth.domain.state.AuthState
import com.volsu.unijournal.core.util.base_components.ScreenComponent
import com.volsu.unijournal.core.util.extension.isNotMatchEmailPattern

class AuthComponent(
    componentContext: ComponentContext,
    private val navigator: AuthNavigator,
    private val updateTransition: UpdateTransitionUseCase
) : ScreenComponent<AuthState, AuthEvents>(
    initialState = AuthState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: AuthEvents) {
        when (event) {
            is AuthEvents.OnEmailChanged -> {
                update {
                    it.copy(
                        email = event.newValue,
                        isEmailError = false
                    )
                }
            }

            is AuthEvents.OnPasswordChanged -> {
                update {
                    it.copy(
                        password = event.newValue,
                        isPasswordError = false
                    )
                }
            }

            AuthEvents.OnAuth -> {
                if (isValid()) {
                }
            }
        }
    }

    private fun isValid(): Boolean {
        var valid = true

        with(state.value) {
            if (email.isNotMatchEmailPattern() || isEmailError) {
                update { it.copy(isEmailError = true) }
                valid = false
            }
            if (password.isNotPasswordMatch() || isPasswordError) {
                update { it.copy(isPasswordError = true) }
                valid = false
            }
        }

        return valid
    }

    private fun String.isNotPasswordMatch(): Boolean {
        return this.isEmpty() || this.length < 6
    }
}