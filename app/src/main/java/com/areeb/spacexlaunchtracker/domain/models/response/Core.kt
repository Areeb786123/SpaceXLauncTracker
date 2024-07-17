package com.areeb.spacexlaunchtracker.domain.models.response

import com.google.gson.annotations.SerializedName

data class Core(
    val block: Any,
    @SerializedName("core_serial")
    val coreSerial: String,
    val flight: Int,
    val gridfins: Boolean,
    @SerializedName("land_success")
    val landSuccess: Any,
    @SerializedName("landing_intent")
    val landingIntent: Boolean,
    @SerializedName("landing_type")
    val landingType: Any,
    @SerializedName("landing_vehicle")
    val landingVehicle: Any,
    val legs: Boolean,
    val reused: Boolean
)