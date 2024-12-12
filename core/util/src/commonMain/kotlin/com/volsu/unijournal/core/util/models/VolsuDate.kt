package com.volsu.unijournal.core.util.models

import com.volsu.unijournal.core.util.extension.formatted
import com.volsu.unijournal.core.util.extension.toLocalDate
import com.volsu.unijournal.core.util.extension.utcMillis

data class VolsuDate(
    val millis: Long
) {
    companion object {
        val today = VolsuDate(utcMillis)
    }

    fun representAsString(): String {
        return millis.toLocalDate().formatted()
    }
}
