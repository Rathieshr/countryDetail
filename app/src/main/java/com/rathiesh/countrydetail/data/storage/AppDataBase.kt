package com.rathiesh.countrydetail.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rathiesh.countrydetail.data.storage.dao.MainDao
import com.rathiesh.countrydetail.data.storage.entity.CountryEntity

@Database(
    entities = [CountryEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun mainDao(): MainDao
}