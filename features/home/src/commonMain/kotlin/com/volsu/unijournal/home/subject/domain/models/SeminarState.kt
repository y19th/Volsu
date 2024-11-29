package com.volsu.unijournal.home.subject.domain.models

internal data class SeminarState(
    val performance: List<Pair<String, PerformancePoints>>
)

internal fun seminarTestState() = SeminarState(
    performance = listOf(
        "5.09.2024" to PerformancePoints(15),
        "6.10.2024" to PerformancePoints(3),
        "10.10.2024" to PerformancePoints.absence,
        "9.11.2024" to PerformancePoints(20),
        "10.11.2024" to PerformancePoints.empty,
        "11.11.2024" to PerformancePoints(35),
        "18.11.2024" to PerformancePoints.empty,
    )
)

