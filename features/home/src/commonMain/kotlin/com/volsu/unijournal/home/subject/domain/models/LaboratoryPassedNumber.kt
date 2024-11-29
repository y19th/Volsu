package com.volsu.unijournal.home.subject.domain.models

import kotlin.jvm.JvmInline

@JvmInline
internal value class LaboratoryPassedNumber(
    val passed: Int
) {
    companion object {

        private const val EMPTY = -5141
        private const val ABSENCE = -152

        val absence = LaboratoryPassedNumber(ABSENCE)
        val empty = LaboratoryPassedNumber(EMPTY)
    }

    fun isEmpty() = passed == EMPTY

    fun isAbsence() = passed == ABSENCE

    override fun toString(): String {
        return passed.toString()
    }

}