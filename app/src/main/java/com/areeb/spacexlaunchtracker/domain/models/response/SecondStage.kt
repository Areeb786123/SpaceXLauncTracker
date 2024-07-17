package com.areeb.spacexlaunchtracker.domain.models.response

data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
)