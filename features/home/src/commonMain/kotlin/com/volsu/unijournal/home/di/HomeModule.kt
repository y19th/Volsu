package com.volsu.unijournal.home.di

import com.volsu.unijournal.home.group.ui.GroupComponent
import com.volsu.unijournal.home.main.ui.MainComponent
import com.volsu.unijournal.home.root.ui.HomeComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeModule = module {
    factoryOf(::HomeComponent)
    factoryOf(::MainComponent)
    factoryOf(::GroupComponent)
}