@file:Suppress("ConstPropertyName")

package com.volsu.unijournal.subject.performance_detail.domain.models

import androidx.compose.runtime.Composable
import com.volsu.unijournal.core.util.models.VolsuDate

private const val PERFORMANCE_PLACEHOLDER = -125241

sealed interface DetailState {

    companion object {
        const val placeholder = PERFORMANCE_PLACEHOLDER
    }

    fun id(): Int
    fun first(): VolsuDate
    fun second(): Int
    fun secondAsString(): String
    fun copyFirst(newFirst: VolsuDate): DetailState
    fun copySecond(newSecond: Int): DetailState

    @Composable
    fun firstTitle(): String

    @Composable
    fun secondTitle(): String
}