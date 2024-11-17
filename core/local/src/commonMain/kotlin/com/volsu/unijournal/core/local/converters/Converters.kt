package com.volsu.unijournal.core.local.converters

import androidx.room.TypeConverter
import com.volsu.unijournal.core.util.models.Transition

class TransitionConverter {

    @TypeConverter
    fun transitionToInt(value: Transition) = value.value()

    @TypeConverter
    fun intToTransition(value: Int) = Transition.find(value)
}









