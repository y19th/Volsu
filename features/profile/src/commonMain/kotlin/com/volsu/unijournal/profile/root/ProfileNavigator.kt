package com.volsu.unijournal.profile.root

import com.volsu.unijournal.core.util.base_components.BaseNavigator

interface ProfileNavigator: BaseNavigator<Unit> {

    fun logout()

    fun navigateBackHome()
}