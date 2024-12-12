package com.volsu.unijournal.subject.performance_detail.domain.models

import androidx.compose.runtime.Composable
import com.volsu.unijournal.core.util.models.VolsuDate

internal fun DetailSeminar.Companion.testDetailSeminarState(): List<DetailSeminar> {
    return listOf(
        DetailSeminar(1, VolsuDate.today, DetailState.placeholder),
        DetailSeminar(2, VolsuDate.today, 3),
        DetailSeminar(3, VolsuDate.today, DetailState.placeholder),
        DetailSeminar(4, VolsuDate.today, 4),
        DetailSeminar(5, VolsuDate.today, DetailState.placeholder),
        DetailSeminar(6, VolsuDate.today, DetailState.placeholder),
    )
}

internal data class DetailSeminar(
    val id: Int,
    val date: VolsuDate,
    val performance: Int
) : DetailState {
    companion object {
        val empty = DetailSeminar(-1, VolsuDate.today, DetailState.placeholder)
        fun idEmpty(id: Int) = DetailSeminar(id, VolsuDate.today, DetailState.placeholder)
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
        return "Дата семинара"
    }

    @Composable
    override fun secondTitle(): String {
        return "Баллы"
    }

    private fun performanceString(): String =
        if (performance == DetailState.placeholder)
            ""
        else
            performance.toString()

}
