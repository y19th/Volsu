@file:Suppress("ConstPropertyName")

package com.volsu.unijournal.subject.performance_detail.domain.models

private const val PERFORMANCE_PLACEHOLDER = -125241

sealed interface DetailState {

    companion object {
        const val placeholder = PERFORMANCE_PLACEHOLDER
    }

    fun first(): String
    fun second(): Int
    fun secondAsString(): String
    fun copyFirst(newFirst: String): DetailState
    fun copySecond(newSecond: Int): DetailState
}