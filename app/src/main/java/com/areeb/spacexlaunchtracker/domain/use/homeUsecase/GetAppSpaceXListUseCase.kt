package com.areeb.spacexlaunchtracker.domain.use.homeUsecase

import android.content.Context
import android.util.Log
import com.areeb.spacexlaunchtracker.data.Resource
import com.areeb.spacexlaunchtracker.data.locale.appDataBase.AppDataBase
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.domain.repo.HomeRepo
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import com.areeb.spacexlaunchtracker.utils.constants.StringConstants.Companion.SOMETHING_WENT_WRONG
import com.areeb.spacexlaunchtracker.utils.network.NetworkConnection
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAppSpaceXListUseCase @Inject constructor(
    @ApplicationContext val context: Context,
    private val homeRepo: HomeRepo,
    private val appDataBase: AppDataBase
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<SpaceXListResponse>>> {
        return flow {
            if (NetworkConnection.isNetworkConnected(context)) {
                try {
                    val data = homeRepo.getSpaceXList()
                    Log.e("Areebo", data.toString())
                    emit(Resource.Success(data))
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(SOMETHING_WENT_WRONG))
                }
            } else {
                val data = mutableListOf<SpaceXListResponse>()
                data.clear()
                appDataBase.cachedDao().cachedEntity().forEach {
                    data.add(it.rocket)
                }
                emit(Resource.Success(data))
            }


        }.flowOn(Dispatchers.IO)

    }
}