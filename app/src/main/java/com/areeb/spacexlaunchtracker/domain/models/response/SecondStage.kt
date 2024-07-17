package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
):Parcelable