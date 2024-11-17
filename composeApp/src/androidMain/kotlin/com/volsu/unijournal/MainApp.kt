package com.volsu.unijournal

import android.app.Application
import android.content.Context
import com.volsu.unijournal.core.local.shared.databaseBuilder
import com.volsu.unijournal.di.initKoin
import org.koin.dsl.module

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            additionalModules = module {
                single<Context> { this@MainApp }
                single {
                    databaseBuilder.create("${applicationContext.filesDir}/database.db")
                }
            }
        )
    }
}