package com.volsu.unijournal.profile.di

import com.volsu.unijournal.profile.root.ui.ProfileComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val profileModule = module {
    factoryOf(::ProfileComponent)
}