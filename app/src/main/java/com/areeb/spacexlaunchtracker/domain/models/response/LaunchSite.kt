package com.areeb.spacexlaunchtracker.domain.models.response

import com.google.gson.annotations.SerializedName

data class LaunchSite(
    val site_id: String,
    val site_name: String,
    val site_name_long: String
)