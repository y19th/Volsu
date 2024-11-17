package com.volsu.unijournal.splash.splash.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.core.util.models.Transition

data class SplashState(
    val transition: Transition? = null,
): BaseState
