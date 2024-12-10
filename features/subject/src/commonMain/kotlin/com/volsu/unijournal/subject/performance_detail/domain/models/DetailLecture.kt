package com.volsu.unijournal.subject.performance_detail.domain.models

internal fun DetailLecture.Companion.testDetailLectureState(): List<DetailLecture> {
    return listOf(
        DetailLecture(1, "1", DetailState.placeholder),
        DetailLecture(2, "2", 3),
        DetailLecture(3, "3", DetailState.placeholder),
        DetailLecture(4, "4", 4),
        DetailLecture(5, "5", DetailState.placeholder),
        DetailLecture(6, "6", DetailState.placeholder),
    )
}

internal data class DetailLecture(
    val id: Int,
    val date: String,
    val performance: Int
) : DetailState {
    companion object {
        val empty = DetailLecture(-1, "", DetailState.placeholder)

    }

    override fun first(): String = date

    override fun second(): Int = performance

    override fun secondAsString(): String {
        return performanceString()
    }

    override fun copyFirst(newFirst: String): DetailState {
        return copy(date = newFirst)
    }

    override fun copySecond(newSecond: Int): DetailState {
        return copy(performance = newSecond)
    }

    private fun performanceString(): String =
        if (performance == DetailState.placeholder)
            ""
        else
            performance.toString()

}
