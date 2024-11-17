package com.volsu.unijournal.home.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.volsu.unijournal.home.group.ui.GroupScreen
import com.volsu.unijournal.home.main.ui.MainScreen
import com.volsu.unijournal.home.subject.ui.SubjectScreen

@Composable
fun HomeScreen(
    component: HomeComponent
) {
    val stack = component.childStack.subscribeAsState()

    Children(
        stack = stack.value,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {
            is HomeComponent.Child.MainChild -> {
                MainScreen(component = instance.component)
            }

            is HomeComponent.Child.GroupChild -> {
                GroupScreen(component = instance.component)
            }

            is HomeComponent.Child.SubjectChild -> {
                SubjectScreen(component = instance.component)
            }
        }
    }
}