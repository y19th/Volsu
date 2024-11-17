package com.volsu.unijournal.home.subject.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.volsu.unijournal.core.ui.components.texts.TextSemibold
import com.volsu.unijournal.core.ui.theme.volsuColorPalette
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.home.subject.domain.events.SubjectEvents
import com.volsu.unijournal.home.subject.ui.components.PerformanceLimitTable
import com.volsu.unijournal.home.subject.ui.components.SubjectPerformance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SubjectScreen(
    component: SubjectComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()
    val testPerformance = remember {
        listOf(
            "5.09.2024" to 8,
            "6.10.2024" to 2,
            "10.10.2024" to 2,
            "9.11.2024" to 1,
            "10.11.2024" to 2,
            "11.11.2024" to 0,
            "18.11.2024" to 6,
        )
    }

    VolsuColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState()),
        topBar = {
            NavigationTopBar(
                navigationIcon = {
                    BackNavigationIcon { handleEvents(SubjectEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        VerticalSpacer(height = 24.dp)

        TextSemibold(
            modifier = Modifier
                .fillMaxWidth(0.85f),
            text = state.value.subject,
            fontSize = 26.sp,
            lineHeight = 30.sp,
            color = volsuColorPalette.primaryTextColor
        )

        VerticalSpacer(height = 12.dp)

        SubjectPerformance(
            items = testPerformance
        )

        VerticalSpacer(height = 24.dp)

        PerformanceLimitTable()
    }
}