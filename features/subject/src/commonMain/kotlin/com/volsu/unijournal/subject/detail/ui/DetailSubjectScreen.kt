package com.volsu.unijournal.subject.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.subject.detail.domain.events.DetailEvents
import com.volsu.unijournal.subject.detail.ui.components.DetailUiSubjectType
import com.volsu.unijournal.subject.root.domain.models.string

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailSubjectScreen(
    component: DetailSubjectComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    VolsuColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState()),
        topBar = {
            NavigationTopBar(
                title = state.value.type.string(),
                navigationIcon = {
                    BackNavigationIcon { handleEvents(DetailEvents.OnNavigateBack) }
                },
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .padding(all = 4.dp)
                    )
                }
            )
        }
    ) {
        DetailUiSubjectType(
            type = state.value.type,
            onAttendanceClick = {
                handleEvents(DetailEvents.OnNavigateToUserAttendance(it))
            }
        )
    }
}