package com.volsu.unijournal.core.domain.mapper

import com.volsu.unijournal.core.domain.models.Group
import com.volsu.unijournal.core.util.models.GroupConfig

fun GroupConfig.asGroupModel() = Group(name)

fun Group.asConfig() = GroupConfig(name)