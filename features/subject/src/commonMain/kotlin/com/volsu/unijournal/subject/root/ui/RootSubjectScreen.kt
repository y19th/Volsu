package com.volsu.unijournal.subject.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.volsu.unijournal.subject.attendance_detail.ui.AttendanceDetailScreen
import com.volsu.unijournal.subject.detail.ui.DetailSubjectScreen
import com.volsu.unijournal.subject.performance_detail.ui.PerformanceDetailScreen
import com.volsu.unijournal.subject.subject.ui.SubjectScreen
import com.volsu.unijournal.subject.today_attendance.ui.TodayAttendanceScreen

@Composable
fun RootSubjectScreen(
    component: RootSubjectComponent
) {
    val stack = component.childStack.subscribeAsState()

    Children(
        stack = stack.value,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {
            is RootSubjectComponent.Child.DetailChild -> {
                DetailSubjectScreen(component = instance.component)
            }

            is RootSubjectComponent.Child.MainChild -> {
                SubjectScreen(component = instance.component)
            }

            is RootSubjectComponent.Child.AttendanceDetailChild -> {
                AttendanceDetailScreen(component = instance.component)
            }

            is RootSubjectComponent.Child.PerformanceDetailChild -> {
                PerformanceDetailScreen(component = instance.component)
            }

            is RootSubjectComponent.Child.TodayAttendanceChild -> {
                TodayAttendanceScreen(component = instance.component)
            }
        }
    }
}