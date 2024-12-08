package com.volsu.unijournal.subject.root

import com.volsu.unijournal.core.util.base_components.BaseNavigator
import com.volsu.unijournal.subject.root.ui.RootSubjectComponent

interface SubjectNavigator : BaseNavigator<RootSubjectComponent.Configuration> {

    fun navigateBack()
}