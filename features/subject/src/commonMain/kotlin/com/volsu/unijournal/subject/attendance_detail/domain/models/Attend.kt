package com.volsu.unijournal.subject.attendance_detail.domain.models

import com.volsu.unijournal.subject.subject.domain.models.AttendanceMark
import kotlinx.collections.immutable.persistentListOf

internal data class Attend(
    val id: Int,
    val date: String,
    val was: AttendanceMark
) {
    companion object {
        val testState = persistentListOf(
            Attend(1, "1", AttendanceMark.Positive),
            Attend(2, "2", AttendanceMark.Negative),
            Attend(3, "3", AttendanceMark.Negative),
            Attend(4, "4", AttendanceMark.Positive),
        )

        fun empty(id: Int) = Attend(id, "", AttendanceMark.Negative)
    }
}

