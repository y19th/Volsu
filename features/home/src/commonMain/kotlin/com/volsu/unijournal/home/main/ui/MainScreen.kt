package com.volsu.unijournal.home.main.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volsu.unijournal.core.domain.models.Group
import com.volsu.unijournal.core.ui.components.VerticalSpacer
import com.volsu.unijournal.core.ui.components.VolsuColumn
import com.volsu.unijournal.core.ui.components.bars.SettingsIcon
import com.volsu.unijournal.core.ui.components.bars.VolsuTopBar
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.home.main.domain.events.MainEvents
import com.volsu.unijournal.home.main.ui.components.SelectableRow

@Composable
internal fun MainScreen(
    component: MainComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()
    val testList = remember {
        Group.testList
    }

    LaunchedEffect(Unit) {
        handleEvents(MainEvents.OnRefresh)
    }

    VolsuColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp),
        topBar = {
            VolsuTopBar(
                contentText = "Агапченко Олег",
                additionalText = state.value.currentRole.string(),
                trailingIcon = {
                    SettingsIcon { handleEvents(MainEvents.OnNavigateToProfile) }
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
                    text = "Учебные группы",
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
                    icon = Icons.Default.People,
                    onClick = {
                        handleEvents(MainEvents.OnNavigateToGroup(item))
                    }
                )

                VerticalSpacer(height = 12.dp)
            }
        }

    }
}