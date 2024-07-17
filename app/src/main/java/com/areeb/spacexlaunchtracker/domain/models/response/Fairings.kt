package com.areeb.spacexlaunchtracker.domain.models.response

import com.google.gson.annotations.SerializedName

data class Fairings(
    val recovered: Boolean,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Boolean,
    val reused: Boolean,
    val ship: Any
)