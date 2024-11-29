package com.volsu.unijournal.core.domain.mapper

import com.volsu.unijournal.core.domain.models.Subject
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.local.entities.subjects.SubjectEntity
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import kotlinx.collections.immutable.toImmutableList

fun SubjectEntity.toSubjectModel() = Subject(
    name = name,
    type = type.toSubjectForm()
)

fun List<SubjectEntity>.toImmutableSubjectsList() = map { it.toSubjectModel() }.toImmutableList()

fun Subject.toSubjectEntity() = SubjectEntity(
    name = name,
    type = type.toSubjectType()
)

fun SubjectType.toSubjectForm() = when(this) {
    SubjectType.Laboratory -> SubjectForm.Laboratory
    SubjectType.Lecture -> SubjectForm.Lecture
    SubjectType.Seminar -> SubjectForm.Seminar
}

fun SubjectForm.toSubjectType() = when(this) {
    SubjectForm.Laboratory -> SubjectType.Laboratory
    SubjectForm.Lecture -> SubjectType.Lecture
    SubjectForm.Seminar -> SubjectType.Seminar
}