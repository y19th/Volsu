package com.volsu.unijournal.core.ui.components.snack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.volsu.unijournal.core.ui.components.snack.data.SnackStatus
import com.volsu.unijournal.core.ui.components.snack.data.VolsuSnackbarData
import com.volsu.unijournal.core.util.extension.cancelOnDelay
import com.volsu.unijournal.core.util.local.LocalSnackbar
import com.volsu.unijournal.core.util.models.SnackState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

private val snackbarDuration = 2.seconds

@Composable
fun GlobalSnackEffect(
    stateFlow: StateFlow<SnackState>
) {
    val snackbar = LocalSnackbar.current
    LaunchedEffect(Unit) {
        stateFlow
            .onEach { state ->
                val message = state.message
                if (message != null) {
                    launch {
                        snackbar.showSnackbar(
                            visuals = VolsuSnackbarData(
                                message = message,
                                status = SnackStatus.find(state.status.value)
                            )
                        )
                    }.cancelOnDelay(snackbarDuration)
                }
            }.launchIn(this)
    }
}