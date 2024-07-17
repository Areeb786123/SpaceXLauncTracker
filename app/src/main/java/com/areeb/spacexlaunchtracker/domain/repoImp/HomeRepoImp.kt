package com.areeb.spacexlaunchtracker.domain.repoImp

import android.util.Log
import com.areeb.spacexlaunchtracker.data.HomeService
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.domain.repo.HomeRepo
import java.lang.Exception
import javax.inject.Inject

class HomeRepoImp @Inject constructor(private val homeService: HomeService) : HomeRepo {
    override suspend fun getSpaceXList(): List<SpaceXListResponse> {
        return try {
            val data = homeService.getsAllSpaceXList()
            Log.e("checkingData", data.toString())
            data
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}