package com.volsu.unijournal.home.group.domain.state

import com.volsu.unijournal.core.domain.models.Group
import com.volsu.unijournal.core.util.base_components.BaseState

data class GroupState(
    val group: Group
): BaseState
