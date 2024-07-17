package com.areeb.spacexlaunchtracker.di

import com.areeb.spacexlaunchtracker.domain.repo.HomeRepo
import com.areeb.spacexlaunchtracker.domain.repoImp.HomeRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoInjection {
    @Provides
    @Singleton
    fun provide(homeRepoImp: HomeRepoImp): HomeRepo {
        return homeRepoImp
    }
}