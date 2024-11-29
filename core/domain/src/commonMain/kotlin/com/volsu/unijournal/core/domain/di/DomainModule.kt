package com.volsu.unijournal.core.domain.di

import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.domain.use_cases.subject.InsertSubjectUseCase
import com.volsu.unijournal.core.domain.use_cases.subject.ReceiveSubjectsUseCase
import com.volsu.unijournal.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.volsu.unijournal.core.domain.use_cases.transition.UpdateTransitionUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    single { VolsuDispatchers() }
    factoryOf(::ReceiveTransitionUseCase)
    factoryOf(::UpdateTransitionUseCase)
    factoryOf(::InsertSubjectUseCase)
    factoryOf(::ReceiveSubjectsUseCase)
}
