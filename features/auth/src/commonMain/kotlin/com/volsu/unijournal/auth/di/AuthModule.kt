package com.volsu.unijournal.auth.di

import com.volsu.unijournal.auth.auth.ui.AuthComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule = module {
    factoryOf(::AuthComponent)
}