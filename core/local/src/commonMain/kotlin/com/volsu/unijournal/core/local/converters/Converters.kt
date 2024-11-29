package com.volsu.unijournal.core.local.converters

import androidx.room.TypeConverter
import com.volsu.unijournal.core.local.entities.subjects.SubjectType
import com.volsu.unijournal.core.util.extension.decode
import com.volsu.unijournal.core.util.extension.encode
import com.volsu.unijournal.core.util.models.Transition

class TransitionConverter {

    @TypeConverter
    fun transitionToInt(value: Transition) = value.value()

    @TypeConverter
    fun intToTransition(value: Int) = Transition.find(value)
}

class SubjectTypeConverter {

    @TypeConverter
    fun subjectTypeToString(value: SubjectType): String = value.encode()

    @TypeConverter
    fun stringToSubjectType(value: String): SubjectType = value.decode()
}








