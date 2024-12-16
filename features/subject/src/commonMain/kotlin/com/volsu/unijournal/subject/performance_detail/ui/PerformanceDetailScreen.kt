package com.volsu.unijournal.subject.performance_detail.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.AnimatedChanges
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.EditableIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.subject.performance_detail.domain.events.PerformanceDetailEvents
import com.volsu.unijournal.subject.performance_detail.ui.components.PerformanceDetailUiBySubjectType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PerformanceDetailScreen(
    component: PerformanceDetailComponent
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
                title = state.value.user,
                navigationIcon = {
                    BackNavigationIcon { handleEvents(PerformanceDetailEvents.OnNavigateBack) }
                },
                trailingIcon = {
                    EditableIcon(
                        editableNow = state.value.editableMode,
                        onClick = { handleEvents(PerformanceDetailEvents.OnToggleEditableMode) }
                    )
                }
            )
        }
    ) {
        PerformanceDetailUiBySubjectType(
            uncollectedState = state,
            onSubjectChange = {
                handleEvents(PerformanceDetailEvents.OnSubjectChange(it))
            },
            onAddSubject = {
                handleEvents(PerformanceDetailEvents.OnAddSubject)
            }
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        AnimatedChanges(
            visible = state.value.hasChanges,
            onCommit = {
                handleEvents(PerformanceDetailEvents.OnSaveChanges)
            },
            onDiscard = {
                handleEvents(PerformanceDetailEvents.OnRejectChanges)
            }
        )
    }
}