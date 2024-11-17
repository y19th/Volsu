package com.volsu.unijournal.splash.splash

import com.volsu.unijournal.core.util.base_components.BaseNavigator
import com.volsu.unijournal.core.util.models.Transition

interface SplashNavigator: BaseNavigator<Unit> {

    fun proceed(transition: Transition)
}