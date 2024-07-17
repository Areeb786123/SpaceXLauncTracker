package com.areeb.spacexlaunchtracker.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.spacexlaunchtracker.data.Resource
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.domain.use.homeUsecase.HomeUseCase
import com.areeb.spacexlaunchtracker.ui.common.viewModel.BaseViewModel
import com.areeb.spacexlaunchtracker.ui.main.screens.HomeFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : BaseViewModel() {
    private val _spaceXList = MutableLiveData<List<SpaceXListResponse>>(emptyList())
    val spaceXList: LiveData<List<SpaceXListResponse>> get() = _spaceXList

    private val _currentMission = MutableLiveData<SpaceXListResponse?>(null)
    val currentMission: LiveData<SpaceXListResponse?> get() = _currentMission

    companion object {
        private const val TAG = "homeViewModel"
    }

    fun setCurrentMission(mission: SpaceXListResponse) {
        _currentMission.value = mission
    }

    fun clearMission() {
        _currentMission.value = null
    }

    init {
        getAllSpaceXList()
    }

    private fun getAllSpaceXList() {
        isLoading()
        viewModelScope.launch {
            homeUseCase.getAppSpaceXListUseCase.invoke().collect {
                setAllSpaceListState(it)
            }
        }
    }

    private fun setAllSpaceListState(resource: Resource<List<SpaceXListResponse>>) {
        Log.e(TAG, resource.toString())
        when (resource) {

            is Resource.Success -> {
                clearLoading()
                _spaceXList.value = resource.data
            }

            is Resource.Error -> {

                Log.e(TAG, resource.error)

            }

            is Resource.Loading -> {
                isLoading()
            }
        }
    }
}