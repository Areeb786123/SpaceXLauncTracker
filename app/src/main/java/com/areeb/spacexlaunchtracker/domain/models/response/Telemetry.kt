package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Telemetry(
    val flight_club: String
):Parcelable