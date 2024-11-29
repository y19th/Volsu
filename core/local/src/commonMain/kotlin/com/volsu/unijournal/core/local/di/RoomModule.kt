package com.volsu.unijournal.core.local.di

import com.volsu.unijournal.core.local.dao.SubjectDao
import com.volsu.unijournal.core.local.dao.TransitionDao
import com.volsu.unijournal.core.local.database.MainDatabase
import com.volsu.unijournal.core.local.repository.SubjectsRepository
import com.volsu.unijournal.core.local.repository.SubjectsRepositoryImpl
import com.volsu.unijournal.core.local.repository.TransitionRepository
import com.volsu.unijournal.core.local.repository.TransitionRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val roomModule = module {
    factory<TransitionDao> { get<MainDatabase>().transitionDao() }
    factory<SubjectDao> { get<MainDatabase>().subjectDao() }
    factoryOf(::TransitionRepositoryImpl).bind<TransitionRepository>()
    factoryOf(::SubjectsRepositoryImpl).bind<SubjectsRepository>()
}