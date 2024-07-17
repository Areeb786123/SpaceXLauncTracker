package com.areeb.spacexlaunchtracker.domain.models.response

import com.google.gson.annotations.SerializedName

data class Core(
    val block: Any,

    val core_serial: String,
    val flight: Int,
    val gridfins: Boolean,
    val land_success: Boolean,
    val landing_intent: Boolean,
//    @SerializedName("landing_type")
//    val landingType: Any,
//    @SerializedName("landing_vehicle")
//    val landingVehicle: Any,
    val legs: Boolean,
    val reused: Boolean
)