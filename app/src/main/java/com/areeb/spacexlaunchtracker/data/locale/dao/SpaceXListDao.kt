package com.areeb.spacexlaunchtracker.data.locale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.areeb.spacexlaunchtracker.domain.models.entitiy.CachedEntity
import com.areeb.spacexlaunchtracker.domain.models.entitiy.SpaceEntity

@Dao
interface SpaceXListDao {
    @Insert
    suspend fun saveList(list: List<CachedEntity>)

    @Query("SELECT * FROM cachedEntity")
    suspend fun cachedEntity(): List<CachedEntity>

    @Query("DELETE FROM cachedEntity")
    suspend fun clearCachedData()

}