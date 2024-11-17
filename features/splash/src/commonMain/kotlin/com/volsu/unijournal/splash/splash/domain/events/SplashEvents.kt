package com.volsu.unijournal.splash.splash.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

sealed interface SplashEvents: BaseEvents {

    data object OnNavigate: SplashEvents
}