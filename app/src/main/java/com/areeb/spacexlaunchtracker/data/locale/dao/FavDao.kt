package com.areeb.spacexlaunchtracker.data.locale.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.areeb.spacexlaunchtracker.domain.models.entitiy.SpaceEntity
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse


@Dao
interface FavDao {

    @Insert
    suspend fun saveFav(spaceXListResponse: SpaceEntity)

    @Delete
    suspend fun deleteFav(spaceXListResponse: SpaceEntity)

    @Query("SELECT * FROM spaceEntity")
    suspend fun favMissionList(): List<SpaceEntity>
}