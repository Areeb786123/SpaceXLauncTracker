package com.areeb.spacexlaunchtracker.data

sealed class Resource<out Data> {
    data class Success<Data>(val data: Data) : Resource<Data>()
    data class Error(val error: String) : Resource<Nothing>()
    data class Loading(val isLoading: Boolean) : Resource<Nothing>()
}