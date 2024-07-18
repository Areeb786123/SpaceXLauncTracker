package com.areeb.spacexlaunchtracker.domain.models.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.areeb.spacexlaunchtracker.domain.models.response.SpaceXListResponse

@Entity(tableName = "spaceEntity")
data class SpaceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rocket: SpaceXListResponse
)
