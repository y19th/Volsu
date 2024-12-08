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

    open fun string(): String = "unknows"

    @Serializable
    data object Student : Role("student") {
        override fun string(): String {
            return "Студент"
        }
    }

    @Serializable
    data object Teacher : Role("teacher") {
        override fun string(): String {
            return "Преподаватель"
        }
    }
}

fun Role.switch(): Role = when(this) {
    Role.Student -> Role.Teacher
    Role.Teacher -> Role.Student
}
