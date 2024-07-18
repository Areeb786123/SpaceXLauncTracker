package com.areeb.spacexlaunchtracker.data.locale.appDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.areeb.spacexlaunchtracker.data.locale.appDataBase.AppDataBase.Companion.VERSION_ONE
import com.areeb.spacexlaunchtracker.data.locale.converts.Converters
import com.areeb.spacexlaunchtracker.data.locale.dao.FavDao
import com.areeb.spacexlaunchtracker.data.locale.dao.SpaceXListDao
import com.areeb.spacexlaunchtracker.domain.models.entitiy.CachedEntity
import com.areeb.spacexlaunchtracker.domain.models.entitiy.SpaceEntity


@Database(entities = [SpaceEntity::class, CachedEntity::class], version = VERSION_ONE)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val VERSION_ONE = 1
    }

    abstract fun favDao(): FavDao
    abstract  fun cachedDao():SpaceXListDao
}