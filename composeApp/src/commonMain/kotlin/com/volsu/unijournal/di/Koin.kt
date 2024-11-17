package com.volsu.unijournal.di

import com.volsu.unijournal.core.domain.di.domainModule
import com.volsu.unijournal.core.local.di.roomModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(additionalModules: Module): KoinApplication {
    return startKoin {
        modules(
            additionalModules,
            navigatorModule,
            componentModule,
            roomModule,
            domainModule
        )
    }
}
