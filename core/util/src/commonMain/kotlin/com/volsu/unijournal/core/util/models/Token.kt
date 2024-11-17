package com.volsu.unijournal.core.util.models

import com.volsu.unijournal.core.util.extension.encode
import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val access: String,
    val refresh: String
) {
    companion object {
        val Unspecified = Token("", "").encode()
    }
}
