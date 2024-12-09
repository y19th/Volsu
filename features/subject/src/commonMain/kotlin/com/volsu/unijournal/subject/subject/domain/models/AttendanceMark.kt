package com.volsu.unijournal.subject.subject.domain.models

sealed interface AttendanceMark {

    val value: String
    val boolean: Boolean

    data object Positive : AttendanceMark {
        override val value: String = "+"
        override val boolean: Boolean = true
    }

    data object Negative : AttendanceMark {
        override val value: String = "н"
        override val boolean: Boolean = false
    }
}

internal fun Boolean.attendanceMark(): AttendanceMark =
    if (this) AttendanceMark.Positive else AttendanceMark.Negative