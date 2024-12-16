package com.volsu.unijournal.core.domain.models

data class Group(
    val name: String
) {
    companion object {
        val testList = listOf(
            Group("ИСТб-211"),
            Group("ИСТб-221"),
            Group("ИСТб-231"),
            Group("ИСТб-201"),
            Group("МОСб-211")
        )
    }
}
