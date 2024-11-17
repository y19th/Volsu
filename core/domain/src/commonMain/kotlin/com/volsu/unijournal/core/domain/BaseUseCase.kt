package com.volsu.unijournal.core.domain

import com.volsu.unijournal.core.domain.models.VolsuDispatchers
import com.volsu.unijournal.core.util.local.Handler
import com.volsu.unijournal.core.util.local.message
import org.koin.core.component.KoinComponent

abstract class BaseUseCase(
    dispatcher: VolsuDispatchers
): KoinComponent {
    protected val context = dispatcher.io + Handler.coroutineExceptionHandler
    private val tag = this::class.simpleName

    protected fun message(msg: String) {
        message(tag ?: "BaseUseCase", msg)
    }
}