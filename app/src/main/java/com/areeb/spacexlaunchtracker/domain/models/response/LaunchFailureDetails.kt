package com.areeb.spacexlaunchtracker.domain.models.response

data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int
)