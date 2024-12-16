package com.volsu.unijournal.core.util.extension

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

val utcMillis = LocalDate.now().atStartOfDayIn(TimeZone.UTC).toEpochMilliseconds()

fun LocalDate.Companion.now() = dateNow

private val dateNow
    get() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

fun Long.toLocalDate(): LocalDateTime {
    return Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}

fun LocalDateTime.formatted(): String {
    val format = LocalDateTime.Format {
        dayOfMonth(); char('.'); monthNumber(); char('.'); year()
    }
    return format(format)
}

fun LocalDate.formatted(): String {
    val format = LocalDate.Format {
        dayOfMonth(); char('.'); monthNumber(); char('.'); year()
    }
    return format(format)
}