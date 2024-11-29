package com.volsu.unijournal.core.domain.models

sealed interface SubjectForm {

    data object Lecture: SubjectForm

    data object Laboratory: SubjectForm

    data object Seminar: SubjectForm
}