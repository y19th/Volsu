package com.volsu.unijournal.subject.attendance_detail.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.subject.attendance_detail.domain.events.AttendanceDetailEvents
import com.volsu.unijournal.subject.attendance_detail.ui.components.EditableAttendanceTable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AttendanceDetailScreen(
    component: AttendanceDetailComponent
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
                navigationIcon = {
                    BackNavigationIcon { handleEvents(AttendanceDetailEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        VerticalSpacer(height = 24.dp)

        TextSemibold(
            text = state.value.user
        )

        VerticalSpacer(height = 36.dp)

        EditableAttendanceTable(
            initialAttendance = state.value.attendanceState,
            onEditAttend = {
                handleEvents(AttendanceDetailEvents.OnEditAttend(it))
            },
            onAddNewAttend = {
                handleEvents(AttendanceDetailEvents.OnAddNewAttend)
            }
        )
    }
}