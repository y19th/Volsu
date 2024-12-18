package com.volsu.unijournal.core.domain.mapper

import com.volsu.unijournal.core.domain.models.Subject
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.core.local.entities.subjects.SubjectEntity
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun SubjectEntity.toSubjectModel(): Subject = Subject(
    name = name,
    type = type.toSubjectForm()
)

fun List<SubjectEntity>.toImmutableSubjectsList(): ImmutableList<Subject> =
    map { it.toSubjectModel() }.toImmutableList()

fun Subject.toSubjectEntity(): SubjectEntity = SubjectEntity(
    name = name,
    type = type.toSubjectType()
)

fun SubjectType.toSubjectForm(): SubjectForm = when (this) {
    SubjectType.Laboratory -> SubjectForm.Laboratory
    SubjectType.Lecture -> SubjectForm.Lecture
    SubjectType.Seminar -> SubjectForm.Seminar
}

fun SubjectForm.toSubjectType(): SubjectType = when (this) {
    SubjectForm.Laboratory -> SubjectType.Laboratory
    SubjectForm.Lecture -> SubjectType.Lecture
    SubjectForm.Seminar -> SubjectType.Seminar
}