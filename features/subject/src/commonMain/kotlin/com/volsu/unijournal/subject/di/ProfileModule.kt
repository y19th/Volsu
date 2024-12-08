package com.volsu.unijournal.subject.di

import com.volsu.unijournal.subject.detail.DetailSubjectComponent
import com.volsu.unijournal.subject.root.ui.RootSubjectComponent
import com.volsu.unijournal.subject.subject.ui.SubjectComponent
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val subjectModule = module {
    factoryOf(::RootSubjectComponent)
    factoryOf(::SubjectComponent)
    factoryOf(::DetailSubjectComponent)
}