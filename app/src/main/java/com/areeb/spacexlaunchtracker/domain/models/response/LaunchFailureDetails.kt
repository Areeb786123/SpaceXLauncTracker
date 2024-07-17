package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int
):Parcelable