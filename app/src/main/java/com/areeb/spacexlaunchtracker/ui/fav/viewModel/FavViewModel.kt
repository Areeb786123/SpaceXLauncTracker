package com.areeb.spacexlaunchtracker.ui.fav.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.areeb.spacexlaunchtracker.data.locale.appDataBase.AppDataBase
import com.areeb.spacexlaunchtracker.domain.models.entitiy.SpaceEntity
import com.areeb.spacexlaunchtracker.ui.common.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(private val appDataBase: AppDataBase) : BaseViewModel() {
    private val _favXList = MutableLiveData<List<SpaceEntity>>(emptyList())
    val favXList: LiveData<List<SpaceEntity>> get() = _favXList

    init {
        getSavedList()
    }

    fun populateList(): kotlinx.coroutines.flow.Flow<List<SpaceEntity>> {
        return flow {
            val data = appDataBase.favDao().favMissionList()
            emit(data)
        }.flowOn(Dispatchers.IO)
    }

    private fun getSavedList() {
        viewModelScope.launch {
            populateList().collect {
                _favXList.value = it
            }
        }
    }

    fun addFav(safeEntity: SpaceEntity) {
        viewModelScope.launch {
            appDataBase.favDao().saveFav(safeEntity)
        }
    }

    fun removeFav(safeEntity: SpaceEntity) {
        viewModelScope.launch {
            try {
                appDataBase.favDao().deleteFav(safeEntity)
            } catch (e: Exception) {
                Log.e("deleteBase", e.toString())
                e.printStackTrace()
            }

        }
    }


}