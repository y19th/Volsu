package com.volsu.unijournal.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.volsu.unijournal.core.util.models.Transition

@Entity(tableName = "transition")
data class TransitionEntity(
    @PrimaryKey val id: Int = 52,
    val step: Transition = Transition.None
)
