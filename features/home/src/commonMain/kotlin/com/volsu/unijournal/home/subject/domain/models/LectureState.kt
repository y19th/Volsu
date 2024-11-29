package com.volsu.unijournal.home.subject.domain.models

internal data class LectureState(
    val performance: List<Pair<String, PerformancePoints>>
)

internal fun lectureTestState() = LectureState(
    performance = listOf(
        "5.09.2024" to PerformancePoints(8),
        "6.10.2024" to PerformancePoints(3),
        "10.10.2024" to PerformancePoints.absence,
        "9.11.2024" to PerformancePoints.absence,
        "10.11.2024" to PerformancePoints.empty,
        "11.11.2024" to PerformancePoints(25),
        "18.11.2024" to PerformancePoints.empty,
    )
)
