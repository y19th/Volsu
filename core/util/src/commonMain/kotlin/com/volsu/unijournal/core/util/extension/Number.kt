package com.volsu.unijournal.core.util.extension

fun String.toIntOrElse(another: Int): Int {
    return toIntOrNull() ?: another
}