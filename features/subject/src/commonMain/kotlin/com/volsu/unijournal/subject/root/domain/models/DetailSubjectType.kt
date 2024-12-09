package com.volsu.unijournal.subject.root.domain.models

import androidx.compose.runtime.Composable
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.subject.extension.rememberSubjectFormPerformanceText
import kotlinx.serialization.Serializable

@Serializable
sealed interface DetailSubjectType {

    @Serializable
    data object Attendance: DetailSubjectType

    @Serializable
    data class Performance(
        val type: SubjectForm
    ): DetailSubjectType
}

@Composable
fun DetailSubjectType.string() = when(this) {
    DetailSubjectType.Attendance -> {
        "Посещение"
    }
    is DetailSubjectType.Performance -> {
        rememberSubjectFormPerformanceText(type)
    }
}