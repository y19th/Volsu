package com.volsu.unijournal.profile.root.domain.state

import com.volsu.unijournal.core.util.base_components.BaseState
import com.volsu.unijournal.core.util.models.Role

data class ProfileState(
    val currentRole: Role
): BaseState
