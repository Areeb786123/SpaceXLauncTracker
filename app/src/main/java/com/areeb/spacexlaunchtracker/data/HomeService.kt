package com.areeb.spacexlaunchtracker.data

import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import okhttp3.Response
import retrofit2.http.GET

interface HomeService {
    @GET(ApiConstant.V3_LAUNCHES)
    suspend fun getsAllSpaceXList(): List<SpaceXListResponse>
}