package com.volsu.unijournal.subject.performance_detail.domain.models

import androidx.compose.runtime.Composable
import com.volsu.unijournal.core.util.models.VolsuDate

internal fun DetailLaboratory.Companion.testDetailLaboratoryState(): List<DetailLaboratory> {
    return listOf(
        DetailLaboratory(1, VolsuDate.today, DetailState.placeholder),
        DetailLaboratory(2, VolsuDate.today, 3),
        DetailLaboratory(3, VolsuDate.today, DetailState.placeholder),
        DetailLaboratory(4, VolsuDate.today, 4),
        DetailLaboratory(5, VolsuDate.today, DetailState.placeholder),
        DetailLaboratory(6, VolsuDate.today, DetailState.placeholder),
    )
}

internal data class DetailLaboratory(
    val id: Int,
    val date: VolsuDate,
    val performance: Int
) : DetailState {
    companion object {
        val empty = DetailLaboratory(-1, VolsuDate.today, DetailState.placeholder)
        fun idEmpty(id: Int) = DetailLecture(id, VolsuDate.today, DetailState.placeholder)
    }

    override fun id(): Int = id

    override fun first(): VolsuDate = date

    override fun second(): Int = performance

    override fun secondAsString(): String {
        return performanceString()
    }

    override fun copyFirst(newFirst: VolsuDate): DetailState {
        return copy(date = newFirst)
    }

    override fun copySecond(newSecond: Int): DetailState {
        return copy(performance = newSecond)
    }

    @Composable
    override fun firstTitle(): String {
        return "Дата лабораторного практикума"
    }

    @Composable
    override fun secondTitle(): String {
        return "Номер работы"
    }

    private fun performanceString(): String =
        if (performance == DetailState.placeholder)
            ""
        else
            performance.toString()

}
