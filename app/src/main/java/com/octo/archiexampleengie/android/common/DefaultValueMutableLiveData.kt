package com.octo.archiexampleengie.android.common

import android.arch.lifecycle.MutableLiveData

class DefaultValueMutableLiveData<T>(defaultValue: T?) : MutableLiveData<T>() {

    init {
        value = defaultValue
    }
}