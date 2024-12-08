package com.volsu.unijournal.home.main.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.core.util.local.VolsuSettings
import com.volsu.unijournal.core.util.models.Role

internal data class MainState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,

    val currentRole: Role = VolsuSettings.role
) : BaseState
