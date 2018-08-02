package com.octo.archiexampleengie.android.common.binding

import android.databinding.DataBindingComponent

class BindingComponentImpl : DataBindingComponent {
    override fun getBindingAdapters(): BindingAdapters {
        return BindingAdaptersImpl()
    }
}
