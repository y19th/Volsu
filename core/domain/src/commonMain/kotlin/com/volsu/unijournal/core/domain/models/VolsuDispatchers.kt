package com.volsu.unijournal.core.domain.models

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class VolsuDispatchers {
    val io = Dispatchers.IO
    val default = Dispatchers.Default
    val main = Dispatchers.Main
}