package com.areeb.spacexlaunchtracker.domain.models.response

import com.google.gson.annotations.SerializedName

data class Fairings(
    val recovered: Boolean,
    val recovery_attempt: Boolean,
    val reused: Boolean,
//    val ship: Any
)