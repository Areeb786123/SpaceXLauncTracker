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
            Log.e("checkingData", homeService.getsAllSpaceXList().toString())
             homeService.getsAllSpaceXList()

        } catch (e: Exception) {
            Log.e("checkingData",e.toString())
            e.printStackTrace()
            emptyList()
        }
    }
}