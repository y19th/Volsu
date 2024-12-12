package com.volsu.unijournal.core.ui.extension

import androidx.compose.runtime.MutableState

fun MutableState<Boolean>.toggle() {
    this.value = this.value.not()
}