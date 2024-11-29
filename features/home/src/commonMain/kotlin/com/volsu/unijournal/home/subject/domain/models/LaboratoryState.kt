package com.volsu.unijournal.home.subject.domain.models

internal data class LaboratoryState(
    val performance: List<Pair<String, LaboratoryPassedNumber>>,
    val total: Int,
)

internal fun laboratoryTestState() = LaboratoryState(
    performance = listOf(
        "5.09.2024" to LaboratoryPassedNumber(1),
        "6.10.2024" to LaboratoryPassedNumber(2),
        "10.10.2024" to LaboratoryPassedNumber.absence,
        "9.11.2024" to LaboratoryPassedNumber.absence,
        "10.11.2024" to LaboratoryPassedNumber.empty,
        "11.11.2024" to LaboratoryPassedNumber(3),
        "18.11.2024" to LaboratoryPassedNumber.empty,
    ),
    total = 6
)

