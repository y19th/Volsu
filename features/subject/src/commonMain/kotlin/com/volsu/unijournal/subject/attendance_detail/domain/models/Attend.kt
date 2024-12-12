package com.volsu.unijournal.subject.attendance_detail.domain.models

import com.volsu.unijournal.core.util.models.VolsuDate
import com.volsu.unijournal.subject.subject.domain.models.AttendanceMark
import kotlinx.collections.immutable.persistentListOf

internal data class Attend(
    val id: Int,
    val date: VolsuDate,
    val was: AttendanceMark
) {
    companion object {
        val testState = persistentListOf(
            Attend(1, VolsuDate.today, AttendanceMark.Positive),
            Attend(2, VolsuDate.today, AttendanceMark.Negative),
            Attend(3, VolsuDate.today, AttendanceMark.Negative),
            Attend(4, VolsuDate.today, AttendanceMark.Positive),
        )

        fun empty(id: Int) = Attend(id, VolsuDate.today, AttendanceMark.Negative)
    }
}

