package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrbitParams(
//    val apoapsis_km: Int,
//    val arg_of_pericenter: Any,
//    val eccentricity: Any,
//    val epoch: Any,
//    val inclination_deg: Int,
//    val lifespan_years: Any,
//    val longitude: Any,
//    val mean_anomaly: Any,
//    val mean_motion: Any,
//    val periapsis_km: Int,
//    val period_min: Any,
//    val raan: Any,

    val reference_system: String,
    val regime: String,
//    val semi_major_axis_km: Any
):Parcelable