package com.areeb.spacexlaunchtracker.ui.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    open val isLoading: LiveData<Boolean> get() = _isLoading

    open fun clearLoading() {
        _isLoading.value = false
    }

    open fun isLoading() {
        _isLoading.value = true
    }
}