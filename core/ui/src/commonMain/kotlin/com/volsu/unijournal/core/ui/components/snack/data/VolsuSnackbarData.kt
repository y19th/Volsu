package com.volsu.unijournal.core.ui.components.snack.data

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import org.jetbrains.compose.resources.DrawableResource
import volsu.core.ui.generated.resources.Res
import volsu.core.ui.generated.resources.icon_error
import volsu.core.ui.generated.resources.icon_question
import volsu.core.ui.generated.resources.icon_success

internal data class VolsuSnackbarData(
    override val message: String,
    override val actionLabel: String? = null,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val withDismissAction: Boolean = false,
    val status: SnackStatus = SnackStatus.Undefined
) : SnackbarVisuals

internal sealed class SnackStatus(val resource: DrawableResource) {

    companion object {
        fun find(value: Int) = when(value) {
            0 -> Success
            1 -> Failure
            else -> Undefined
        }
    }

    data object Success: SnackStatus(Res.drawable.icon_success)

    data object Failure: SnackStatus(Res.drawable.icon_error)

    data object Undefined: SnackStatus(Res.drawable.icon_question)
}