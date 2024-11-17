package com.volsu.unijournal.core.local.shared

import com.volsu.unijournal.core.local.database.MainDatabase

interface DatabaseBuilder {
    fun create(path: String): MainDatabase
}

expect val databaseBuilder: DatabaseBuilder