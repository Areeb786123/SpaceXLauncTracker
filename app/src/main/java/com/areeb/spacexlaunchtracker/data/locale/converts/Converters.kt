package com.areeb.spacexlaunchtracker.data.locale.converts

import androidx.room.TypeConverter
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.google.gson.Gson



class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSpaceXListResponse(spaceXListResponse: SpaceXListResponse): String {
        return gson.toJson(spaceXListResponse)
    }

    @TypeConverter
    fun toSpaceXListResponse(spaceXListResponseString: String): SpaceXListResponse {
        return gson.fromJson(spaceXListResponseString, SpaceXListResponse::class.java)
    }
}