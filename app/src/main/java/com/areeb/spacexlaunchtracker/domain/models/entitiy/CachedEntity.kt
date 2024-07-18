package com.areeb.spacexlaunchtracker.domain.models.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse


@Entity(tableName = "cachedEntity")
data class CachedEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val rocket: SpaceXListResponse
)
