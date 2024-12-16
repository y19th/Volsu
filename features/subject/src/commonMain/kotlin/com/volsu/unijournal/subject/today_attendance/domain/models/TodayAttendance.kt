package com.volsu.unijournal.subject.today_attendance.domain.models

internal fun testTodayAttendanceState() = listOf(
    TodayAttendance(id = 1, name = "Агапченко О.А. 1", was = false),
    TodayAttendance(id = 2, name = "Агапченко О.А. 2", was = false),
    TodayAttendance(id = 3, name = "Агапченко О.А. 3", was = false),
    TodayAttendance(id = 4, name = "Агапченко О.А. 4", was = false),
    TodayAttendance(id = 5, name = "Агапченко О.А. 5", was = false),
    TodayAttendance(id = 6, name = "Агапченко О.А. 6", was = false),
    TodayAttendance(id = 7, name = "Агапченко О.А. 7", was = false),
    TodayAttendance(id = 8, name = "Агапченко О.А. 8", was = false),
    TodayAttendance(id = 9, name = "Агапченко О.А. 9", was = false),
    TodayAttendance(id = 10, name = "Агапченко О.А. 10", was = false),
    TodayAttendance(id = 11, name = "Агапченко О.А. 11", was = false),
    TodayAttendance(id = 12, name = "Агапченко О.А. 12", was = false),
    TodayAttendance(id = 13, name = "Агапченко О.А. 13", was = false),
    TodayAttendance(id = 14, name = "Агапченко О.А. 14", was = false),
)

internal data class TodayAttendance(
    val id: Int,
    val name: String,
    val was: Boolean
)
