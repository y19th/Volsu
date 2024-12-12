package com.volsu.unijournal.core.util.extension

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

@OptIn(FormatStringsInDatetimeFormats::class)
private val unicodeFormat = LocalDate.Format {
    byUnicodePattern("dd-MM-yyyy")
}

val utcMillis = LocalDate.now().atStartOfDayIn(TimeZone.UTC).toEpochMilliseconds()

val LocalDate.Companion.Unspecified: LocalDate
    get() = fromEpochDays(0)

val LocalDate.Companion.EpochNow
    get() = Clock.System.now().epochSeconds

val LocalDate.Companion.TimeNow
    get() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

fun LocalDate.Companion.now() = dateNow

private val dateNow
    get() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

fun LocalDate.Companion.safeParse(
    sequence: CharSequence,
    format: DateTimeFormat<LocalDate> = unicodeFormat
): LocalDate? {
    val replaced = sequence.toString().replace('.', '-')
    var result = LocalDate.Unspecified
    try {
        result = parse(replaced, format)
    } catch (_: Exception) {
    }

    return if (result == LocalDate.Unspecified) null else result
}

fun Long.toLocalDate(): LocalDateTime {
    return Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}

fun LocalDateTime.isToday(): Boolean {
    return dateNow.toEpochDays() == this.date.toEpochDays()
}

fun LocalDateTime.isYesterday(): Boolean {
    return dateNow.toEpochDays() - 1 == this.date.toEpochDays()
}

fun String.isTodayDate(): Boolean {
    val parsed = LocalDate.safeParse(this.replace('.', '-'), unicodeFormat)
    return if (parsed != null)
        parsed.toEpochDays() == dateNow.toEpochDays() else false
}

fun LocalDateTime.formatted(): String {
    val format = LocalDateTime.Format {
        dayOfMonth(); char('.'); monthNumber(); char('.'); year()
    }
    return format(format)
}