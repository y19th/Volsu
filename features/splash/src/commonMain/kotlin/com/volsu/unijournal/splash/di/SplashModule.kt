package com.volsu.unijournal.splash.di

import com.volsu.unijournal.splash.splash.ui.SplashComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val splashModule = module {
    factoryOf(::SplashComponent)
}