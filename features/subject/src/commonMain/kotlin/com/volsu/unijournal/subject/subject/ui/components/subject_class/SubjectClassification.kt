package com.volsu.unijournal.subject.subject.ui.components.subject_class

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import com.volsu.unijournal.core.domain.models.SubjectForm
import com.volsu.unijournal.subject.subject.domain.models.laboratoryTestState
import com.volsu.unijournal.subject.subject.domain.models.lectureTestState
import com.volsu.unijournal.subject.subject.domain.models.seminarTestState
import com.volsu.unijournal.subject.subject.ui.components.subject_class.lab.LaboratorySubjectContent
import com.volsu.unijournal.subject.subject.ui.components.subject_class.lecture.LectureSubjectContent
import com.volsu.unijournal.subject.subject.ui.components.subject_class.seminar.SeminarSubjectContent

@Composable
internal fun SubjectClassification(
    subjectForm: SubjectForm
) {
    val state = rememberUpdatedState(subjectForm)

    when (state.value) {
        SubjectForm.Laboratory -> {
            LaboratorySubjectContent(remember { laboratoryTestState() })
        }

        SubjectForm.Lecture -> {
            LectureSubjectContent(remember { lectureTestState() })
        }

        SubjectForm.Seminar -> {
            SeminarSubjectContent(remember { seminarTestState() })
        }
    }
}