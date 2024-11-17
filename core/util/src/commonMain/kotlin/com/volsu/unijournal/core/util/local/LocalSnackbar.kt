package com.volsu.unijournal.core.util.local

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf
import com.volsu.unijournal.core.util.models.SnackState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

val LocalSnackbar = staticCompositionLocalOf { SnackbarHostState() }

object SnackFlow {

    private val flow = MutableStateFlow(SnackState.empty)

    fun collect(): StateFlow<SnackState> = flow.asStateFlow()

    fun show(state: SnackState) {
        flow.value = state
    }
}
