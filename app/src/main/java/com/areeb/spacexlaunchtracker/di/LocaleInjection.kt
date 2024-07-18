package com.areeb.spacexlaunchtracker.di

import android.content.Context
import androidx.room.Room
import com.areeb.spacexlaunchtracker.data.locale.appDataBase.AppDataBase
import com.areeb.spacexlaunchtracker.data.locale.dao.FavDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocaleInjection {
    @Provides
    @Singleton
    fun providesDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "ROOM_DB").build()
    }

    @Provides
    @Singleton
    fun provideFavDao(appDataBase: AppDataBase): FavDao {
        return appDataBase.favDao()
    }

}