package com.areeb.spacexlaunchtracker.domain.models.response

data class LaunchFailureDetails(
    val altitude: Any,
    val reason: String,
    val time: Int
)