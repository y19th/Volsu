package com.volsu.unijournal

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.volsu.unijournal.core.util.extension.getComponent
import com.volsu.unijournal.root.RootComponent
import com.volsu.unijournal.root.RootScreen
import org.koin.core.component.KoinComponent

private object KoinResolver : KoinComponent {

    fun injectRootComponent(context: ComponentContext): RootComponent =
        getComponent<RootComponent>(context)
}

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController() = ComposeUIViewController {
    val backDispatcher = BackDispatcher()
    val root = KoinResolver.injectRootComponent(
        context = DefaultComponentContext(
            lifecycle = ApplicationLifecycle(),
            backHandler = backDispatcher
        )
    )

    PredictiveBackGestureOverlay(
        backDispatcher = backDispatcher,
        backIcon = null
    ) {
        RootScreen(component = root)
    }
}