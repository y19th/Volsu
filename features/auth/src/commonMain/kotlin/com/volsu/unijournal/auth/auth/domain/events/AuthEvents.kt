package com.volsu.unijournal.auth.auth.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

sealed interface AuthEvents: BaseEvents {

    data class OnEmailChanged(val newValue: String): AuthEvents

    data class OnPasswordChanged(val newValue: String): AuthEvents

    data object OnAuth: AuthEvents
}