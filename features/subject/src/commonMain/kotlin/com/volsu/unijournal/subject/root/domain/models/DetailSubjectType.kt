package com.volsu.unijournal.subject.root.domain.models

import kotlinx.serialization.Serializable

@Serializable
sealed interface DetailSubjectType {

    @Serializable
    data object Attendance: DetailSubjectType

    @Serializable
    data object Performance: DetailSubjectType
}

fun DetailSubjectType.string() = when(this) {
    DetailSubjectType.Attendance -> {
        "Посещение"
    }
    DetailSubjectType.Performance -> {
        "Performance"
    }
}