package com.volsu.unijournal.home.root

import com.volsu.unijournal.core.util.base_components.BaseNavigator
import com.volsu.unijournal.home.root.ui.HomeComponent

interface HomeNavigator: BaseNavigator<HomeComponent.Configuration> {

    fun navigateToProfile()
}