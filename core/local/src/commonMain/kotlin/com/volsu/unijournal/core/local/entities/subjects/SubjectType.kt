package com.volsu.unijournal.core.local.entities.subjects

import kotlinx.serialization.Serializable

@Serializable
sealed interface SubjectType {

    @Serializable
    data object Lecture: SubjectType

    @Serializable
    data object Laboratory: SubjectType

    @Serializable
    data object Seminar: SubjectType
}