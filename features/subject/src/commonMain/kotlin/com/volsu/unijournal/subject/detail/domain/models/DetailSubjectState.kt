package com.volsu.unijournal.subject.detail.domain.models

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

sealed interface DetailSubjectState {

    data class Attendance(
        val items: ImmutableList<String>
    ) : DetailSubjectState {
        companion object {
            val testState = Attendance(
                items = persistentListOf(
                    "Агапченко О.А. 1",
                    "Агапченко О.А. 2",
                    "Агапченко О.А. 3",
                    "Агапченко О.А. 4",
                    "Агапченко О.А. 5",
                )
            )
        }
    }

    data class DetailAttendance(
        val items: ImmutableList<Pair<String, Boolean>>
    ) : DetailSubjectState
}
