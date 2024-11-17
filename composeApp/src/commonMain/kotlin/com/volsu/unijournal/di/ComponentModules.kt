package com.volsu.unijournal.di

import com.volsu.unijournal.core.domain.di.domainModule
import com.volsu.unijournal.auth.auth.AuthNavigator
import com.volsu.unijournal.auth.di.authModule
import com.volsu.unijournal.navigator.AuthNavigatorImpl
import com.volsu.unijournal.navigator.RootNavigator
import com.volsu.unijournal.navigator.RootNavigatorImpl
import com.volsu.unijournal.navigator.SplashNavigatorImpl
import com.volsu.unijournal.splash.di.splashModule
import com.volsu.unijournal.splash.splash.SplashNavigator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigatorModule = module {
    singleOf(::RootNavigatorImpl).bind<RootNavigator>()
    singleOf(::SplashNavigatorImpl).bind<SplashNavigator>()
    singleOf(::AuthNavigatorImpl).bind<AuthNavigator>()
}

val componentModule = module {
    includes(
        splashModule, rootModule,
        authModule, domainModule
    )
}