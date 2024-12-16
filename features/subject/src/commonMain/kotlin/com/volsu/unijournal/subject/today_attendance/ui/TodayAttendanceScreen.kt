package com.volsu.unijournal.subject.today_attendance.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.AnimatedChanges
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.EditableIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.ui.components.texts.TextMedium
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.core.util.extension.formatted
import com.volsu.unijournal.core.util.extension.now
import com.volsu.unijournal.subject.today_attendance.domain.events.TodayAttendanceEvents
import com.volsu.unijournal.subject.today_attendance.ui.components.TodayAttendanceTable
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TodayAttendanceScreen(
    component: TodayAttendanceComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()
    val date = rememberSaveable {
        LocalDate.now().formatted()
    }

    VolsuColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState()),
        topBar = {
            NavigationTopBar(
                title = "Посещение",
                navigationIcon = {
                    BackNavigationIcon { handleEvents(TodayAttendanceEvents.OnNavigateBack) }
                },
                trailingIcon = {
                    EditableIcon(
                        editableNow = state.value.editableState,
                        onClick = {
                            handleEvents(TodayAttendanceEvents.OnToggleEditableState)
                        }
                    )
                }
            )
        }
    ) {
        VerticalSpacer(height = 24.dp)

        TextMedium(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            text = "Отметьте посещение группы ${state.value.group.name} за $date",
            fontSize = 16.sp,
            color = volsuColorPalette.primaryTextColor
        )

        VerticalSpacer(height = 16.dp)

        TodayAttendanceTable(
            editable = state.value.editableState,
            attendance = state.value.attendance,
            onEditAttend = {
                handleEvents(TodayAttendanceEvents.OnEditAttend(it))
            }
        )

        VerticalSpacer(height = 32.dp)

        AnimatedChanges(
            visible = state.value.hasChanges,
            onCommit = {
                handleEvents(TodayAttendanceEvents.OnCommitChanges)
            },
            onDiscard = {
                handleEvents(TodayAttendanceEvents.OnDiscardChanges)
            }
        )
    }
}