package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Core(
//    val block: Any,
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
) : Parcelable