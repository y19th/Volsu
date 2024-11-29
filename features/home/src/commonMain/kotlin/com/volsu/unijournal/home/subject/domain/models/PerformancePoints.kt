package com.volsu.unijournal.home.subject.domain.models

import kotlin.jvm.JvmInline

@JvmInline
internal value class PerformancePoints(
    val points: Int
) {
    companion object {

        private const val EMPTY = -2941
        private const val ABSENCE = -49212

        val absence = PerformancePoints(ABSENCE)
        val empty = PerformancePoints(EMPTY)
    }

    fun isEmpty() = points == EMPTY

    fun isAbsence() = points == ABSENCE

    override fun toString(): String {
        return points.toString()
    }
}