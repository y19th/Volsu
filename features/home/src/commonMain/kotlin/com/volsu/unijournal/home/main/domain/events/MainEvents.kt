package com.volsu.unijournal.home.main.domain.events

import com.volsu.unijournal.core.util.base_components.BaseEvents

internal sealed interface MainEvents: BaseEvents {

    data object OnRefresh: MainEvents

    data class OnNavigateToGroup(val group: String): MainEvents
}