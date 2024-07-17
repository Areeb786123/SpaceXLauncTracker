package com.areeb.spacexlaunchtracker.domain.use.homeUsecase

import com.areeb.spacexlaunchtracker.domain.repo.HomeRepo
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    val getAppSpaceXListUseCase: GetAppSpaceXListUseCase
)
