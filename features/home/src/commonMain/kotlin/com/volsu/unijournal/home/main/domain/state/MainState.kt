package com.volsu.unijournal.home.main.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState

internal data class MainState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
) : BaseState
