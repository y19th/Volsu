package com.volsu.unijournal.core.util.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.volsu.unijournal.core.util.extension.decode
import com.volsu.unijournal.core.util.extension.encode
import com.volsu.unijournal.core.util.models.BuildProperties
import com.volsu.unijournal.core.util.models.Role

object VolsuSettings {

    private val settings: Settings = Settings()

    var properties: BuildProperties
        get() = settings[Keys.BUILD_PROPERTIES, BuildProperties.Default].decode()
        set(value) = settings.putString(Keys.BUILD_PROPERTIES, value.encode())

    var role: Role
        get() = Role.decode(settings[Keys.ROLE, Role.Student.value])
        set(value) = settings.putString(Keys.ROLE, value.value)

}

private object Keys {

    const val BUILD_PROPERTIES = "build_properties"
    const val ROLE = "role"
}