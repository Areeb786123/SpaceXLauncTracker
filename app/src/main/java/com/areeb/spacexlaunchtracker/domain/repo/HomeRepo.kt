package com.areeb.spacexlaunchtracker.domain.repo

import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse

interface HomeRepo {
    suspend fun  getSpaceXList():List<SpaceXListResponse>
}