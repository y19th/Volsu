package com.volsu.unijournal.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.volsu.unijournal.auth.auth.ui.AuthScreen
import com.volsu.unijournal.core.ui.components.snack.GlobalSnackEffect
import com.volsu.unijournal.core.ui.components.snack.VolsuSnackbarHost
import com.volsu.unijournal.core.ui.theme.VolsuTheme
import com.volsu.unijournal.core.util.local.LocalSnackbar
import com.volsu.unijournal.core.util.local.SnackFlow
import com.volsu.unijournal.core.util.local.VolsuSettings
import com.volsu.unijournal.core.util.models.BuildProperties
import com.volsu.unijournal.home.root.ui.HomeScreen
import com.volsu.unijournal.konfig.BuildKonfig
import com.volsu.unijournal.profile.root.ui.ProfileScreen
import com.volsu.unijournal.shared.isDebug
import com.volsu.unijournal.splash.splash.ui.SplashScreen

@Composable
fun RootScreen(
    component: RootComponent
) {
    val stack = component.childStack.subscribeAsState()
    val snackbar = LocalSnackbar.current

    VolsuSettings.properties = BuildProperties(
        name = BuildKonfig.appVersionName,
        code = BuildKonfig.appVersionCode,
        debug = isDebug
    )

    val animator = slide()

    VolsuTheme {

        GlobalSnackEffect(
            stateFlow = SnackFlow.collect()
        )

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            snackbarHost = {
                VolsuSnackbarHost(hostState = snackbar)
            }
        ) {

            Children(
                stack = stack.value,
                animation = stackAnimation(
                    animator = animator,
                    disableInputDuringAnimation = true
                )
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.SplashChild -> {
                        SplashScreen(component = instance.component)
                    }

                    is RootComponent.Child.AuthChild -> {
                        AuthScreen(component = instance.component)
                    }

                    is RootComponent.Child.HomeChild -> {
                        HomeScreen(component = instance.component)
                    }

                    is RootComponent.Child.ProfileChild -> {
                        ProfileScreen(component = instance.component)
                    }
                }
            }
        }
    }
}