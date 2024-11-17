package com.volsu.unijournal.core.util.extension

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T: Any> T.encode(): String {
    return Json.encodeToString(value = this)
}


inline fun <reified T: Any> String.decode(): T {
    return Json.decodeFromString(this)
}