package com.volsu.unijournal.profile.root.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

sealed interface ProfileEvents: BaseEvents {

    data object OnNavigateBack: ProfileEvents

    data object OnLogout: ProfileEvents

    data object OnSwitchRole: ProfileEvents
}