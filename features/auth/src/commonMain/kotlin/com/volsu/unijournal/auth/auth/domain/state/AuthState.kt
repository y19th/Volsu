package com.volsu.unijournal.auth.auth.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState

data class AuthState(
    val email: String = "aaa@aaa.ru",
    val password: String = "123456",

    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,

    val isLoading: Boolean = false
): BaseState
