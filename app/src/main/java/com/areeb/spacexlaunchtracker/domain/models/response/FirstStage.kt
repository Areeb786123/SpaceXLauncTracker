package com.areeb.spacexlaunchtracker.domain.models.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FirstStage(
    val cores: List<Core>
):Parcelable