package com.volsu.unijournal.home.subject.ui

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
import com.volsu.unijournal.core.util.base_components.rememberHandleEvents
import com.volsu.unijournal.core.util.extension.collectAsImmediateState
import com.volsu.unijournal.home.subject.domain.events.SubjectEvents
import com.volsu.unijournal.home.subject.ui.components.SubjectTitle
import com.volsu.unijournal.home.subject.ui.components.performance.PerformanceLimitTable
import com.volsu.unijournal.home.subject.ui.components.subject_class.SubjectClassification

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SubjectScreen(
    component: SubjectComponent
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
                    BackNavigationIcon { handleEvents(SubjectEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        VerticalSpacer(height = 24.dp)

        SubjectTitle(
            subjectName = state.value.subject,
            subjectForm = state.value.form
        )

        VerticalSpacer(height = 12.dp)

        SubjectClassification(
            subjectForm = state.value.form
        )
    }
}