package com.areeb.spacexlaunchtracker.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.spacexlaunchtracker.data.Resource
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse
import com.areeb.spacexlaunchtracker.domain.use.homeUsecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {
    private val _spaceXList = MutableLiveData<List<SpaceXListResponse>>(emptyList())
    val spaceXList: LiveData<List<SpaceXListResponse>> get() = _spaceXList

    companion object {
        private const val TAG = "homeViewModel"
    }

    init {
        getAllSpaceXList()
    }

    private fun getAllSpaceXList() {
        viewModelScope.launch {
            homeUseCase.getAppSpaceXListUseCase.invoke().collectLatest {
                setAllSpaceListState(it)
            }
        }
    }

    private fun setAllSpaceListState(resource: Resource<List<SpaceXListResponse>>) {
        when (resource) {
            is Resource.Success -> {

                _spaceXList.value = resource.data
            }

            is Resource.Error -> {

                Log.e(TAG, resource.error)

            }

            is Resource.Loading -> {

            }
        }
    }
}