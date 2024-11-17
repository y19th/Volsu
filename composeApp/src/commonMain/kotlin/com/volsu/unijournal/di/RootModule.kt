package com.volsu.unijournal.di

import com.volsu.unijournal.root.RootComponent
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rootModule = module {
    singleOf(::RootComponent)
}