package com.volsu.unijournal

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform