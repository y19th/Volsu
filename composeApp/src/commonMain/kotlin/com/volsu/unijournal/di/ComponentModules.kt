package com.volsu.unijournal.di

import com.volsu.unijournal.auth.auth.AuthNavigator
import com.volsu.unijournal.auth.di.authModule
import com.volsu.unijournal.core.domain.di.domainModule
import com.volsu.unijournal.home.di.homeModule
import com.volsu.unijournal.home.root.HomeNavigator
import com.volsu.unijournal.navigator.AuthNavigatorImpl
import com.volsu.unijournal.navigator.HomeNavigatorImpl
import com.volsu.unijournal.navigator.ProfileNavigatorImpl
import com.volsu.unijournal.navigator.RootNavigator
import com.volsu.unijournal.navigator.RootNavigatorImpl
import com.volsu.unijournal.navigator.SplashNavigatorImpl
import com.volsu.unijournal.navigator.SubjectNavigatorImpl
import com.volsu.unijournal.profile.di.profileModule
import com.volsu.unijournal.profile.root.ProfileNavigator
import com.volsu.unijournal.splash.di.splashModule
import com.volsu.unijournal.splash.splash.SplashNavigator
import com.volsu.unijournal.subject.di.subjectModule
import com.volsu.unijournal.subject.root.SubjectNavigator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigatorModule = module {
    singleOf(::RootNavigatorImpl).bind<RootNavigator>()
    singleOf(::SplashNavigatorImpl).bind<SplashNavigator>()
    singleOf(::AuthNavigatorImpl).bind<AuthNavigator>()
    singleOf(::HomeNavigatorImpl).bind<HomeNavigator>()
    singleOf(::ProfileNavigatorImpl).bind<ProfileNavigator>()
    singleOf(::SubjectNavigatorImpl).bind<SubjectNavigator>()
}

val componentModule = module {
    includes(
        splashModule, rootModule, homeModule,
        authModule, domainModule, profileModule,
        subjectModule
    )
}