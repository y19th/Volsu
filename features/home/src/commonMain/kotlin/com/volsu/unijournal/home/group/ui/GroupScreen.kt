package com.volsu.unijournal.home.group.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.BackNavigationIcon
import com.volsu.unijournal.core.ui.components.bars.NavigationTopBar
import com.volsu.unijournal.core.ui.components.bars.SettingsIcon
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.home.group.domain.events.GroupEvents
import com.volsu.unijournal.home.main.ui.components.SelectableRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GroupScreen(
    component: GroupComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()
    val testList = remember { listOf("Базы данных", "Дискретная математика", "Паралелльное программирование") }

    VolsuColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp),
        topBar = {
            NavigationTopBar(
                title = state.value.groupModel,
                navigationIcon = {
                    BackNavigationIcon { handleEvents(GroupEvents.OnNavigateBack) }
                },
                trailingIcon = {
                    SettingsIcon { handleEvents(GroupEvents.OnNavigateToSettings) }
                }
            )
        }
    ) {
        LazyColumn {
            item {
                VerticalSpacer(height = 36.dp)
            }
            item {
                TextSemibold(
                    text = "Предметы",
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    color = volsuColorPalette.primaryColor
                )
            }
            item {
                VerticalSpacer(height = 16.dp)
            }
            items(testList) { item ->
                SelectableRow(
                    text = item,
                    icon = Icons.AutoMirrored.Filled.LibraryBooks,
                    onClick = {
                        handleEvents(GroupEvents.OnNavigateToSubject(item))
                    }
                )

                VerticalSpacer(height = 12.dp)
            }
        }

    }
}