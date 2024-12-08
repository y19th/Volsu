package com.volsu.unijournal.core.util.models

import kotlinx.serialization.Serializable

@Serializable
sealed class Role(val value: String) {

    companion object {
        fun decode(value: String) = when (value) {
            "student" -> Student
            else -> Teacher
        }
    }

    @Serializable
    data object Student : Role("student")

    @Serializable
    data object Teacher : Role("teacher")
}

fun Role.switch(): Role = when(this) {
    Role.Student -> Role.Teacher
    Role.Teacher -> Role.Student
}
