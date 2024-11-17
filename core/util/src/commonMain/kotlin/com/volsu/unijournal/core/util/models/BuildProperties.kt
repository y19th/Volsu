package com.volsu.unijournal.core.util.models

import com.volsu.unijournal.core.util.extension.encode
import kotlinx.serialization.Serializable

@Serializable
data class BuildProperties(
    val name: String,
    val code: Int,
    val debug: Boolean = false
) {
    companion object {
        val Default = BuildProperties("", 1).encode()
    }
}

fun BuildProperties.versionName() = "v$name"